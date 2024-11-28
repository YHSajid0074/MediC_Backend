package com.example.doctorAppointment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MenuItemResponseDto {
    private String menuName;
    private String route;
    private boolean isAction;
    private Long weight;
    private String icon;
    private Long parentId; // Optional: ID of the parent MenuItem
    private List<MenuItemResponseDto> children; // Recursive children
}
