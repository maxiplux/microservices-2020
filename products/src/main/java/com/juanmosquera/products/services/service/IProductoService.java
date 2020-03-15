package com.juanmosquera.products.services.service;



import com.juanmosquera.products.models.Product;

import java.util.List;


public interface IProductoService {

	public List<Product> findAll();
	public Product findById(Long id);
}
