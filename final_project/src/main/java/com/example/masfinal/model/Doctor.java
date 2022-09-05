package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Entity, representing doctor
 */
@Table(name = "doctor")
@Entity
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_doctor")
    private String nameDoctor;

    @Column(name = "surname_doctor")
    private String surnameDoctor;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "career_start")
    private LocalDate careerStart;

    @OrderBy("dateOfVisit DESC")
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "doctor_id")
    private Set<Visit> visits;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

}