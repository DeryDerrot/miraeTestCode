package com.mirae.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private int orderID;

    @Column(name = "customer_id", nullable = false)
    private int customerID;

    @Column(name = "employees_id", nullable = false)
    private int employeesID;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "purchase_order_number", nullable = false)
    private String purchaseOrderNumber;

    @Column(name = "ship_date", nullable = false)
    private Date shipDate;

    @Column(name = "shipping_method_id", nullable = false)
    private int shippingMethodID;

    @Column(name = "freight_charge", nullable = false)
    private int freightCharge;

    private int taxes;

    @Column(name = "payment_received", nullable = false)
    private int paymentReceived;

    private String comment;
}
