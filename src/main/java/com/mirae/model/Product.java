package com.mirae.model;

import lombok.Data;

@Data
public class Product {

    private int productID;
    private String productName;
    private int unitPrice;
    private int inStock;
}
