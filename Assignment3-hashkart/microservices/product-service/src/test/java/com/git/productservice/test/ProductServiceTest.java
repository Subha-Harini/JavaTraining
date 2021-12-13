package com.git.productservice.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.git.dataaccesslayer.entity.Product;
import com.git.dataaccesslayer.repository.ProductRepository;
import com.git.productservice.service.ProductService;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductService productService;
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	Product product;
	
	
	@Test
	public void addProductTest() {
		when(productRepository.save(product)).thenReturn(product);
		productService.addProduct(product);
		
	}
	
	@Test
	public void addProductExpTest() {
		Product p = null;
		when(productRepository.save(p)).thenReturn(p);
		productService.addProduct(p);
		
	}
	
	@Test
	public void deleteProductTest() {
		productService.deleteProduct(Mockito.anyInt());
	}
	
	@Test
	public void getAllProductsTest() {
		productService.getAllProducts();
	}
	
	@Test
	public void getProductTest() {
		Optional prod = Optional.of(product);
		when(productRepository.findById(Mockito.anyInt())).thenReturn(prod);
		productService.getProduct(Mockito.anyInt());
	}
	
	@Test
	public void sortByPriceTest() {
		productService.sortByPrice();
	}
	
	@Test
	public void sortByRatingTest() {
		productService.sortByRating();
	}
	
}
