package com.mirae.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Data
public class OrderModel extends RepresentationModel<OrderModel> {

    private int orderId;
    private int subtotalOrders;
    private int shippingCosts;
    private int taxes;
    private int totalCosts;
    private Date orderDate;
    private Date shipDate;
    private String purchaseOrderNumber;
    private String paymentReceived;
    private String comment;
    private Customer customerData;
    private Employee employeeData;
    private Shipping shippingData;
    private List<OrderDetail> orderDetail;
}
