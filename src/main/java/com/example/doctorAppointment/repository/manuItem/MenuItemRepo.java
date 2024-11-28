package com.example.doctorAppointment.repository.manuItem;


import com.example.doctorAppointment.dto.response.MenuItemResponseDto;
import com.example.doctorAppointment.dto.response.MenuItemSearchDto;
import com.example.doctorAppointment.model.module.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface MenuItemRepo extends JpaRepository <MenuItem,Long> {

    Optional<MenuItem> findByMenuNameIgnoreCase(String menuName);

    List<MenuItem> findByMenuNameIgnoreCaseIn(Set<String> menuName);

   // List<MenuItem> findByIsActionFalseAndIsActiveTrue(Sort sort);

    @Query("""
          SELECT m
          FROM MenuItem m
          JOIN FETCH m.children
          WHERE m.parent.id IS NULL
          """)
    List<MenuItem> findAllByParentIdIsNull();

    @Modifying
    @Transactional
    @Query("DELETE FROM MenuItem m WHERE m.id IN (:menuActions)")
    void deleteAllById(List<Long> menuActions);

    @Query("SELECT m FROM MenuItem m WHERE m.parent IS NULL")
    List<MenuItem> findByParentModuleIsNull();

    @Query("SELECT m FROM MenuItem m WHERE m.parent IS NULL")
    List<MenuItemSearchDto> findByParentModuleIsNull1();


    @Query("SELECT m FROM MenuItem m WHERE m.parent = :parentModule")
    List<MenuItem> findByParentModule(@Param("parentModule") MenuItem parentModule);

    @Query("SELECT m FROM MenuItem m WHERE m.parent.id = :parentId")
    List<MenuItemResponseDto> findSubmodulesByParentId(@Param("parentId") Long parentId);
}