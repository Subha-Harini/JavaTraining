package com.git.billservice.test;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.git.billservice.service.CartService;
import com.git.dataaccesslayer.entity.Cart;
import com.git.dataaccesslayer.entity.Product;
import com.git.dataaccesslayer.entity.User;
import com.git.dataaccesslayer.entity.UserCart;
import com.git.dataaccesslayer.repository.CartRepository;
import com.git.dataaccesslayer.repository.ProductRepository;
import com.git.dataaccesslayer.repository.UserRepository;

@ExtendWith(SpringExtension.class)
public class CartServiceTest {
	@InjectMocks
	CartService cartService;
	
	@Mock
	UserCart userCart;
	
	@Mock
	CartRepository cartRepository;
	
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	ProductRepository productRepository;
	
	
	@Mock
	Cart cart;
	
	@Mock
	User user;
	
	@Mock
	Product product;
	
	@Test
	public void addToCartTest() {
		Optional userOp = Optional.of(user);
		Optional ProdOp = Optional.of(product);
		when(userRepository.findById(Mockito.any())).thenReturn(userOp);
		when(productRepository.findById(Mockito.any())).thenReturn(ProdOp);
		when(cartRepository.save(cart)).thenReturn(new Cart(0, user, product));
		cartService.addToCart(userCart);
	}
	
	@Test
	public void addToCartCartNullTest() {
		Optional userOp = Optional.of(user);
		Optional ProdOp = Optional.of(product);
		when(userRepository.findById(Mockito.any())).thenReturn(userOp);
		when(productRepository.findById(Mockito.any())).thenReturn(ProdOp);
		Cart c = null;
		when(cartRepository.save(cart)).thenReturn(c);
		cartService.addToCart(userCart);
	}



}
