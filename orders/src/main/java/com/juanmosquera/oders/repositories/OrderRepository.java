package com.juanmosquera.oders.repositories;


import com.juanmosquera.oders.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    public List<Order> findOrdersByAccountId(String accountId);
    public Order findOrderByOrderId(String orderId);
}
