package com.mirae.model;

import lombok.Data;

@Data
public class OrderDetail {

    private int orderDetailID;
    private int productID;
    private String productName;
    private int qty;
    private int price;
    private int dicount;
    private int total;
}
