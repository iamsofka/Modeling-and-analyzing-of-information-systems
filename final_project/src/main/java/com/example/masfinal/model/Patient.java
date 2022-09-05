package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Entity, representing patient
 */
@Table(name = "patient")
@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_patient", nullable = false)
    private String namePatient;

    @Column(name = "surname_patient", nullable = false)
    private String surnamePatient;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "complaints")
    private String complaints;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id")
    private Set<Prescription> prescriptions;

    @OrderBy("dateOfVisit DESC")
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id")
    private Set<Visit> visits;

}