package com.mirae.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="shipping_methods")
public class ShippingEntity {

    @Id
    @GeneratedValue
    @Column(name = "shipping_method_id")
    private int shippingMethodID;

    @Column(name = "shipping_method", nullable = false)
    private String shippingMethod;
}
