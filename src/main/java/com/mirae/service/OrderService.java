package com.mirae.service;

import com.mirae.entity.*;
import com.mirae.model.Order;
import com.mirae.model.OrderDetail;
import com.mirae.repository.*;
import com.mirae.util.Common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ShippingService shippingService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    Common common;

    public Page<Order> fetchOrderData(int page, int size) {
        log.info("============ fetch order data");
        List<Order> orders = new ArrayList<>();

        // create Pageable object using the page, size
        Pageable pageable = PageRequest.of(page, size);
        // fetch the page object by additionally passing pageable
        List<OrderEntity> orderList = orderRepository.findAllOrder(pageable);
        long count = orderRepository.count();

        for (OrderEntity order : orderList) {
            log.info("============ order Id : {}", order.getOrderID());
            int totalCosts;
            int subtotalOrders = 0;
            String paymentReceivedStatus;
            Order orderData = new Order();
            List<OrderDetail> orderDetails = new ArrayList<>();

            int taxes = order.getTaxes();
            int freightCharge = order.getFreightCharge();

            orderData.setOrderId(order.getOrderID());
            orderData.setShippingCosts(freightCharge);
            orderData.setOrderDate(order.getOrderDate());
            orderData.setShipDate(order.getShipDate());
            orderData.setPurchaseOrderNumber(order.getPurchaseOrderNumber());
            paymentReceivedStatus = order.getPaymentReceived() == 1 ? "paid" : "waiting payment";
            orderData.setPaymentReceived(paymentReceivedStatus);
            orderData.setComment(order.getComment());
            orderData.setTaxes(taxes);

            orderData.setCustomerData(customerService.findCustomerById(order.getCustomerID()));
            orderData.setShippingData(shippingService.findShippingById(order.getShippingMethodID()));
            orderData.setEmployeeData(employeeService.findEmployeeById(order.getEmployeesID()));

            Map<String, Object> map = orderDetailService.findAllOrderDetailById(order.getOrderID());
            for (int i = 0; i < map.size(); i++) {
                subtotalOrders = (int) map.get("subtotalOrders");
                orderDetails = (List<OrderDetail>) map.get("orderDetails");
            }
            orderData.setOrderDetail(orderDetails);
            orderData.setSubtotalOrders(subtotalOrders);

            totalCosts = common.sumTotalCost(taxes, freightCharge, subtotalOrders);
            orderData.setTotalCosts(totalCosts);

            orders.add(orderData);
        }

        return new PageImpl<>(orders, pageable, count);
    }
}
