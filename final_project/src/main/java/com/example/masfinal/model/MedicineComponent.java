package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entity, representing medicine component
 */
@Table(name = "medicine_component")
@Entity
@Getter
@Setter
public class MedicineComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "usage_instruction")
    private String usageInstruction;

    @Column(name = "comp_man_date")
    private LocalDate compManDate;

    @Column(name = "comp_exp_date")
    private LocalDate compExpDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

}