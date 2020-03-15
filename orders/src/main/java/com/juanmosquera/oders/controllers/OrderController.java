package com.juanmosquera.oders.controllers;


import com.juanmosquera.oders.exception.PaymentNotAcceptedException;
import com.juanmosquera.oders.models.Order;
import com.juanmosquera.oders.models.dto.OrderRequest;
import com.juanmosquera.oders.models.dto.OrderResponse;
import com.juanmosquera.oders.services.OrderService;
import com.juanmosquera.oders.utils.EntityDtoConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private EntityDtoConverter converter;

    @ApiOperation(value = "Retrieve all existed orders", notes = "This Operation returns all stored orders.")
    @GetMapping(value = "order")
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(converter.convertEntityToDto(orders), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve an order based on Id ", notes = "This Operation returns an order by Order Id")
    @GetMapping(value = "order/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId) {
        Optional<Order> order = orderService.findOrderById(orderId);
        // todo : improve optional
        return new ResponseEntity<>(converter.convertEntityToDto(order.get()), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve an order based on Id ", notes = "This Operation returns an order by DB Order Id")
    @GetMapping(value = "order/generated/{orderId}")
    public ResponseEntity<OrderResponse> findByGeneratedId(@PathVariable String orderId) {
        Optional<Order> order = orderService.findOrderById(orderId);
        return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.OK);
    }



    @ApiOperation(value = "Creates an order", notes = "This Operation creates a new order.")
    @PostMapping(value = "order/create")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest payload) throws PaymentNotAcceptedException {
        Order order = orderService.createOrder(payload);
        return new ResponseEntity<>(converter.convertEntityToDto(order), HttpStatus.CREATED);
    }
}
