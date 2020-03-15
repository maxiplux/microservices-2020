package com.juanmosquera.oders.services.impl;

import com.juanmosquera.oders.models.Order;
import com.juanmosquera.oders.models.OrderDetail;
import com.juanmosquera.oders.models.dto.OrderRequest;
import com.juanmosquera.oders.repositories.OrderRepository;
import com.juanmosquera.oders.services.OrderService;
import com.juanmosquera.oders.services.OrderValidator;
import com.juanmosquera.oders.utils.Constants;
import com.juanmosquera.oders.utils.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOrderById(String orderId) {
      return   this.orderRepository.findById(orderId);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Order createOrder(OrderRequest orderRequest) {
        OrderValidator.validateOrder(orderRequest);
        Order order=new Order();
        order.setAccountId(orderRequest.getAccountId());
        Order orderObj = new Order();
        orderObj.setOrderId(UUID.randomUUID().toString());
        orderObj.setAccountId(orderRequest.getAccountId());
        orderObj.setStatus(OrderStatus.PENDING);

        List<OrderDetail> orderDetails = orderRequest.getItems().stream()
                .map(item -> OrderDetail.builder()
                        .price(item.getPrice())
                        .quantity(item.getQuantity())
                        .upc(item.getUpc())
                        .tax((item.getPrice() * item.getQuantity()) * Constants.TAX_IMPORT)
                        .totalAmount((item.getPrice() * item.getQuantity()))
                        .order(orderObj).build())
                .collect(Collectors.toList());
        order.setDetails(orderDetails);
        return this.orderRepository.save(order);

    }


}
