package com.mirae.controller;

import com.mirae.handler.ResponseHandler;
import com.mirae.model.Order;
import com.mirae.model.OrderModel;
import com.mirae.service.OrderModelAssembler;
import com.mirae.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mirae")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    private OrderModelAssembler orderModelAssembler;

    @Autowired
    private PagedResourcesAssembler<Order> pagedResourcesAssembler;

    @GetMapping("/orders")
    public ResponseEntity<Object> fetchOrderWithPaginationy(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        log.info("============ Order Controller ============");

        if (size == 0) {
            return ResponseHandler.generateResponse("Size must not be less than one", HttpStatus.BAD_REQUEST, "size : " + size);
        }

        Page<Order> orderPage = orderService.fetchOrderData(page, size);

        // Use the pagedResourcesAssembler and orderModelAssembler to convert data to PagedModel format
        PagedModel<OrderModel> pageModel = pagedResourcesAssembler.toModel(orderPage, orderModelAssembler);

        return ResponseHandler.generateResponse("Ok", HttpStatus.OK, pageModel);
    }
}
