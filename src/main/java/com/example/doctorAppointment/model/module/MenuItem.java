package com.example.doctorAppointment.model.module;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "menuName", nullable = false, length = 50)
    private String menuName;

    @Column(name = "route", length = 150)
    private String route;

    @Column(name = "isSidebar")
    private boolean isSidebar;

    @Column(name = "isAction")
    private boolean isAction;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "icon")
    private String icon;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MenuItem> children;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "fk_menu_item_parent_id"))
    private MenuItem parent;
}
