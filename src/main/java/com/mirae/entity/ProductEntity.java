package com.mirae.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="products")
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int productID;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "unit_price", nullable = false)
    private int unitPrice;

    @Column(name = "in_stock", nullable = false)
    private int inStock;
}
