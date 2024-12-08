package com.example.doctorAppointment.service.impl;


import com.example.doctorAppointment.dto.request.MenuRequestDto;
import com.example.doctorAppointment.dto.response.MenuItemResponseDto;
import com.example.doctorAppointment.dto.response.MenuItemSearchDto;
import com.example.doctorAppointment.model.module.MenuItem;
import com.example.doctorAppointment.repository.manuItem.MenuItemRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl  {

    private final MenuItemRepo menuItemRepo;

    public MenuServiceImpl(MenuItemRepo menuItemRepo) {
        this.menuItemRepo = menuItemRepo;
    }

    public MenuItem convertToEntity(MenuRequestDto menuRequestDto,MenuItem menuItem) {

        menuItem.setMenuName(menuRequestDto.getMenuName());
        menuItem.setIcon(menuRequestDto.getIcon());
        menuItem.setWeight(menuRequestDto.getWeight());
        menuItem.setRoute(menuRequestDto.getRoute());

        return menuItem;
    }


    public void createMenu(MenuRequestDto menuRequestDto) {

        MenuItem menuItem = convertToEntity(menuRequestDto,new MenuItem());
        menuItemRepo.save(menuItem);

    }


    public List<MenuItemResponseDto> getSubmodulesRecursively(MenuItem menuItem) {

        List<MenuItemResponseDto> allSubmodules = new ArrayList<>();
        findSubmodulesRecursive(menuItem, allSubmodules);

        return allSubmodules;
    }


    private void findSubmodulesRecursive(MenuItem module, List<MenuItemResponseDto> allSubmodules) {
        List<MenuItem> submodules = menuItemRepo.findByParentModule(module);

        allSubmodules.addAll(
                submodules.stream()
                        .map(this::mapToResponseDtoWithChildren)
                        .collect(Collectors.toList())
        );

        for (MenuItem submodule : submodules) {
            findSubmodulesRecursive(submodule, allSubmodules);
        }
    }

    // Helper method to map MenuItem to MenuItemResponseDto
    private MenuItemResponseDto mapToResponseDtoWithChildren(MenuItem menuItem) {
        return new MenuItemResponseDto(
                menuItem.getMenuName(),
                menuItem.getRoute(),
                menuItem.isAction(),
                menuItem.getWeight(),
                menuItem.getIcon(),
                menuItem.getParent() != null ? menuItem.getParent().getId() : null,
                menuItem.getChildren() != null
                        ? menuItem.getChildren().stream()
                        .map(this::mapToResponseDtoWithChildren)
                        .collect(Collectors.toList())
                        : null
        );
    }


    public List<MenuItemResponseDto> getTopLevelModules1() {
        List<MenuItem> topLevelModules = menuItemRepo.findAllByParentIdIsNull();

        return topLevelModules.stream()
                .map(this::mapToResponseDtoWithChildren)
                .collect(Collectors.toList());

    }


    public List<MenuItem> getTopLevelModules() {
        return menuItemRepo.findByParentModuleIsNull();
    }



    @Transactional
    public MenuItem addChildToMenu(Long parentId, Long childId) {

        MenuItem parentMenuItem = menuItemRepo.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent menu item not found"));

        MenuItem childMenuItem = menuItemRepo.findById(childId)
                .orElseThrow(() -> new RuntimeException("Child menu item not found"));

        childMenuItem.setParent(parentMenuItem);

        menuItemRepo.save(childMenuItem);

        return childMenuItem;
    }



    @Transactional
    public MenuItem addChildrenToMenuById(Long parentId, List<Long> childrenIds) {

        MenuItem parentMenuItem = menuItemRepo.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent menu item not found"));

        List<MenuItem> childMenuItems = menuItemRepo.findAllById(childrenIds);

        if (childMenuItems.isEmpty()) {
            throw new RuntimeException("No valid child menu items found for the provided IDs");
        }

        childMenuItems.forEach(child -> child.setParent(parentMenuItem));

        menuItemRepo.saveAll(childMenuItems);

        return parentMenuItem;
    }

    public List<MenuItem> getAllModules() {
        return menuItemRepo.findAll();
    }


    public MenuItemResponseDto getById(Long id) {

        MenuItem menuItem=menuItemRepo.findById(id).get();
        MenuItemResponseDto menuItemResponseDto=mapToResponseDtoWithChildren(menuItem);
        
        return menuItemResponseDto;
    }

    public List<MenuItemResponseDto> getAll() {

        List<MenuItem> allSubmodules = menuItemRepo.findAll();

        List<MenuItemResponseDto> menuItemResponseDto = new ArrayList<>();
        for (MenuItem menuItem : allSubmodules) {
            menuItemResponseDto.add(mapToResponseDtoWithChildren(menuItem));
        }

        return menuItemResponseDto;
    }

}
