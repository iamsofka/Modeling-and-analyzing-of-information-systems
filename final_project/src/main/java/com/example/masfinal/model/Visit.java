package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entity, representing visit
 */
@Table(name = "visit")
@Entity
@Getter
@Setter
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_of_visit")
    private LocalDate dateOfVisit;

    @Enumerated(EnumType.STRING)
    @Column(name = "visit_type")
    private VisitType visitType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id")
    private Patient patient;

}