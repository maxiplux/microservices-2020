package com.juanmosquera.products.repositories;

import com.juanmosquera.products.models.Product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    public Optional<Product> findBySku(String sku);
}
