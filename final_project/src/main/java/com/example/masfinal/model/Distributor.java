package com.example.masfinal.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Entity, representing distributor
 */
@Table(name = "distributor")
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor
@NoArgsConstructor
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "distributor_vat_num", nullable = false, unique = true)
    private Float distributorVATNum;

    @Column(name = "distributor_name")
    private String distributorName;

    @Column(name = "distributor_location")
    private String distributorLocation;

    @Column(name = "price_with_promotion")
    private Double priceWithPromotion;

    @Column(name = "channel_type", nullable = true)
    private String channelType;

    @Column(name = "promotion", nullable = true)
    private String promotion;

    @Column(name = "working_hours", nullable = true)
    private String workingHours;

    @Column(name = "distribution_method", nullable = true)
    private String distributionMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "distribution_type")
    private DistributionType distributionType;

    @OneToMany(mappedBy = "distributor", cascade = CascadeType.PERSIST)
    private Set<Component> components;

}