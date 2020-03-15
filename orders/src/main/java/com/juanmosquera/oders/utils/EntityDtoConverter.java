package com.juanmosquera.oders.utils;


import com.juanmosquera.oders.models.Order;
import com.juanmosquera.oders.models.dto.OrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public OrderResponse convertEntityToDto(Order order) {
        return modelMapper.map(order, OrderResponse.class);
    }

    public List<OrderResponse> convertEntityToDto(List<Order> orders) {
        return orders.stream()
                .map(order -> convertEntityToDto(order))
                .collect(Collectors.toList());
    }

    public OrderResponse convertEntityToDto(Optional<Order> order) {
        return convertEntityToDto(order.get());
    }
}
