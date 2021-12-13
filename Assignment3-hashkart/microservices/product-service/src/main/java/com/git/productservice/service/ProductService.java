package com.git.productservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.git.dataaccesslayer.entity.Product;
import com.git.dataaccesslayer.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	
	
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	
	@Transactional
	public String addProduct(Product product) {
		Product p = productRepository.save(product);
		if(p!= null) {
			return "product added successfully";
		}
		return "Error adding product";
	}
	

	@Transactional
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}
	
	@Transactional
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Transactional
	public Product getProduct(int productId) {
		Optional<Product> prd = productRepository.findById(productId);
		return prd.get();
	}
	
	@Transactional
	public List<Product> sortByPrice() {
		return productRepository.getSortByPrice();
	}
	
	@Transactional
	public List<Product> sortByRating() {
		return productRepository.getSortByRating();
	}
}
