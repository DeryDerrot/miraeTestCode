package com.mirae.repository;

import com.mirae.entity.OrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    String FIND_ALL_ORDER = "SELECT * FROM orders o";

    @Query(value = FIND_ALL_ORDER, nativeQuery = true)
    List<OrderEntity> findAllOrder(Pageable pageable);

}
