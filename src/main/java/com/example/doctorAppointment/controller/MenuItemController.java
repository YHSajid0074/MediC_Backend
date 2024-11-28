package com.example.doctorAppointment.controller;

import com.example.doctorAppointment.dto.request.MenuRequestDto;
import com.example.doctorAppointment.dto.response.MenuItemResponseDto;
import com.example.doctorAppointment.dto.response.MenuItemSearchDto;
import com.example.doctorAppointment.model.module.MenuItem;
import com.example.doctorAppointment.repository.manuItem.MenuItemRepo;
import com.example.doctorAppointment.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("MenuItem")
public class MenuItemController {

    @Autowired
    private MenuServiceImpl menuServiceImpl;

    @GetMapping("/top-level")
    public List<MenuItemResponseDto> getTopLevelModules() {
        return menuServiceImpl.getTopLevelModules1();
    }

    @GetMapping("/submoduleHeads/{moduleId}")
    public List<MenuItemResponseDto> getSubmoduleHeads(@PathVariable Long moduleId) {
        MenuItem menu = menuServiceImpl.getTopLevelModules().stream()
                .filter( ml -> ml.getId().equals(moduleId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("RootedSubmodules not found"));

        return menuServiceImpl.getSubmodulesRecursively(menu);
    }


    @PostMapping("Create")
    public ResponseEntity<String>Create(MenuRequestDto menuItemRequestDto) {
        menuServiceImpl.createMenu(menuItemRequestDto);
        return ResponseEntity.ok("Menu created");
    }

    @PostMapping("/{parentId}/add-child/{childId}")
    public ResponseEntity<String> addChildToMenu(@PathVariable Long parentId, @PathVariable Long childId) {
        MenuItem updatedChild = menuServiceImpl.addChildToMenu(parentId, childId);
        return ResponseEntity.ok("Successfully added child to the menu");
    }


    @PostMapping("/{parentId}/add-children")
    public ResponseEntity<String> addChildrenToMenu(@PathVariable Long parentId, @RequestBody List<Long> childrenIds) {
        MenuItem updatedParent = menuServiceImpl.addChildrenToMenuById(parentId, childrenIds);
        return ResponseEntity.ok("Successfully added children");
    }


    @GetMapping("/submodules/{moduleId}")
    public List<MenuItemResponseDto> getAllSubmodules(@PathVariable Long moduleId) {
        MenuItem menu = menuServiceImpl.getAllModules().stream()
                .filter(ml -> ml.getId().equals(moduleId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Module not found"));

        return menuServiceImpl.getSubmodulesRecursively(menu);
    }

    @GetMapping("findById/{moduleId}")
    public ResponseEntity<MenuItemResponseDto> getSubmoduleById(@PathVariable Long moduleId) {
        return  ResponseEntity.ok(menuServiceImpl.getById(moduleId));
    }

    @GetMapping("GetAll")
    public ResponseEntity<List<MenuItemResponseDto>> getAllSubmodules() {
       return ResponseEntity.ok(menuServiceImpl.getAll()) ;
    }

}
