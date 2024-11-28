package com.example.doctorAppointment.dto.response;

import java.util.List;

public interface MenuItemSearchDto {
    String getMenuName();
    String getRoute();
    boolean getIsAction();
    Long getWeight();
    String getIcon();
    Long getParentId(); // Optional: ID of the parent MenuItem
    List<MenuItemResponseDto> getChildren(); // Recursive children (this can be nested projections)
}
