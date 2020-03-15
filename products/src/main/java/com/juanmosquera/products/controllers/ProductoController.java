package com.juanmosquera.products.controllers;

import java.util.List;
import java.util.stream.Collectors;


import com.juanmosquera.products.models.Product;
import com.juanmosquera.products.services.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
	
	//@Autowired
	//private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/")
	public List<Product> listar(){
		return productoService.findAll().stream().map(producto ->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));

			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public Product detalle(@PathVariable Long id) throws Exception {
		Product producto = productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));

		//  to test circuit breaker
		/*
		if (true)
		{
			throw  new Exception( "chchahahahahaha");
		}

		 try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*?
		 */

		return producto;
	}

}
