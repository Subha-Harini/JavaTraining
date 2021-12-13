package com.git.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.git.dataaccesslayer.entity.Product;
import com.git.productservice.service.ProductService;

@RestController
@RequestMapping("/hashkart/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		return productService.getProduct(id);
	}
	
	@GetMapping("/sort-by-price")
	public List<Product> sortByPrice() {
		return productService.sortByPrice();
	}
	
	@GetMapping("/sort-by-rating")
	public List<Product> sortByRating() {
		return productService.sortByRating();
	}
	
}
