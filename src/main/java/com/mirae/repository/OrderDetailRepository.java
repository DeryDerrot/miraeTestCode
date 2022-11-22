package com.mirae.repository;


import com.mirae.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer> {

    String GET_ORDER_DETAIL_BY_ID = "select * from order_details od where od.order_id = :orderID";

    @Query(value = GET_ORDER_DETAIL_BY_ID, nativeQuery = true)
    List<OrderDetailEntity> findAllById(int orderID);
}
