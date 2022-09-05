package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


/**
 * Entity, representing clinic
 */
@Table(name = "clinic")
@Entity
@Getter
@Setter
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "clinic_id")
    private Set<Doctor> doctors;

}