package com.example.doctorAppointment.service.impl;


import com.example.doctorAppointment.dto.request.MenuRequestDto;
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



}
