package com.mirae.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="order_details")
public class OrderDetailEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_detail_id")
    private int orderDetailID;

    @Column(name = "order_id", nullable = false)
    private int orderID;

    @Column(name = "product_id", nullable = false)
    private int productID;

    private int quantity;

    @Column(name = "unit_price", nullable = false)
    private int unitPrice;

    private int discount;


}
