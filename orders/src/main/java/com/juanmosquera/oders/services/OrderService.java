package com.juanmosquera.oders.services;

import com.juanmosquera.oders.models.Order;
import com.juanmosquera.oders.models.dto.OrderRequest;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAllOrders();

    Optional<Order> findOrderById(String orderId);

    Order createOrder(OrderRequest payload);

}
