package com.example.masfinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entity, representing shop
 */
@Entity
@Getter
@Setter
public class Shop extends Distributor {
    @Column(name = "name_shop")
    private String nameShop;

    @Column(name = "address_shop")
    private String addressShop;

}