package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Entity, representing medicine
 */
@Table(name = "medicine")
@Entity
@Getter
@Setter
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_medicine", nullable = false, unique = true)
    private String nameMedicine;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "manufacturer_name", nullable = false)
    private String manufacturerName;

    @Column(name = "med_man_date", nullable = false)
    private LocalDate medManDate;

    @Column(name = "med_exp_date", nullable = false)
    private LocalDate medExpDate;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medicine_id")
    private Set<MedicineComponent> medicineComponents;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medicine_id")
    private Set<Prescription> prescriptions;

}