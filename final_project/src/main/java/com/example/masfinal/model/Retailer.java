package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entity, representing retailer
 */
@Entity
@Getter
@Setter
public class Retailer extends Distributor {
    @Column(name = "contact_data")
    private String contactData;

    @Column(name = "possible_amount")
    private Integer possibleAmount;

}