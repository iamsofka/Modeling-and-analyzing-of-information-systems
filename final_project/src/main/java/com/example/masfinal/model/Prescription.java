package com.example.masfinal.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entity, representing prescription
 */
@Table(
        name = "prescription",
        uniqueConstraints = {@UniqueConstraint(columnNames = "id")}
)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

}