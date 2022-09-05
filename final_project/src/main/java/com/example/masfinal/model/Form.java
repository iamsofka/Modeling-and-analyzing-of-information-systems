package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity, representing form
 */
@Table(name = "form")
@Entity
@Getter
@Setter
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "form_name")
    private String formName;

    @Column(name = "form_description")
    private String formDescription;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "form_components",
            joinColumns = @JoinColumn(name = "form_id"),
            inverseJoinColumns = @JoinColumn(name = "components_id"))
    private List<Component> components = new ArrayList<>();

}