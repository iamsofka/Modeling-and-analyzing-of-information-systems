package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entity, representing manufacturer plant
 */
@Entity
@Getter
@Setter
public class ManufacturePlant extends Distributor {
    @Column(name = "minimal_amount")
    private Integer minimalAmount;

    @Column(name = "medical_spec_plant")
    private String medicalSpecPlant;
}