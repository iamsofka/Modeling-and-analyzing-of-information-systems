package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Entity, representing component
 */
@Table(name = "component", indexes = @Index(columnList = "unique_name"))
@Entity
@Getter
@Setter
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "unique_name", unique = true)
    private String uniqueName;

    @Column(name = "needed_amount")
    private Double neededAmount;

    @Column(name = "production_place")
    private String productionPlace;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "COMPONENT_FORM",
            joinColumns = @JoinColumn(name = "COMPONENT_id"),
            inverseJoinColumns = @JoinColumn(name = "FORM_id"))
    private Set<Form> forms;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "component_id")
    private Set<MedicineComponent> medicineComponents;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

}