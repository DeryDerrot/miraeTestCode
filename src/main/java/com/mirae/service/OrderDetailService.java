package com.mirae.service;

import com.mirae.entity.OrderDetailEntity;
import com.mirae.model.OrderDetail;
import com.mirae.model.Product;
import com.mirae.repository.OrderDetailRepository;
import com.mirae.util.Common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductService productService;

    @Autowired
    Common common;

    public Map<String, Object> findAllOrderDetailById(int orderId) {
        log.info("============ find All Order Detail by Id : {}", orderId);
        List<OrderDetail> orderDetails = new ArrayList<>();
        Map<String, Object> map = new LinkedHashMap<>();
        int subtotalOrders = 0;

        List<OrderDetailEntity> orddList = orderDetailRepository.findAllById(orderId);

        for (OrderDetailEntity ode : orddList) {
            OrderDetail orderDetail = new OrderDetail();
            Product prd = productService.findProductById(ode.getProductID());

            int qty = ode.getQuantity();
            int unitPrice = ode.getUnitPrice();
            int discount = ode.getDiscount();

            orderDetail.setProductName(prd.getProductName());
            orderDetail.setProductID(prd.getProductID());
            orderDetail.setQty(qty);
            orderDetail.setPrice(unitPrice);
            orderDetail.setOrderDetailID(ode.getOrderDetailID());
            orderDetail.setDicount(discount);

            int total = common.sumProductPrice(qty, unitPrice, discount);
            orderDetail.setTotal(total);

            subtotalOrders += total;

            orderDetails.add(orderDetail);
        }

        map.put("subtotalOrders", subtotalOrders);
        map.put("orderDetails", orderDetails);

        return map;
    }
}
