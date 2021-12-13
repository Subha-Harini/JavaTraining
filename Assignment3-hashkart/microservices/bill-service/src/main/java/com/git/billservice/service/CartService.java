package com.git.billservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.git.dataaccesslayer.entity.Cart;
import com.git.dataaccesslayer.entity.UserCart;
import com.git.dataaccesslayer.repository.BillRepository;
import com.git.dataaccesslayer.repository.CartRepository;
import com.git.dataaccesslayer.repository.ProductRepository;
import com.git.dataaccesslayer.repository.UserRepository;


@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public String addToCart(UserCart userCart)  {
		System.out.println(userCart);
		System.out.println(cartRepository.findByUserAndProduct(userCart.getUserId(), userCart.getProductId()) );
		if (cartRepository.findByUserAndProduct(userCart.getUserId(), userCart.getProductId()) != null) {
			Cart cart = cartRepository.findByUserAndProduct(userCart.getUserId(), userCart.getProductId());
			cart.setQuantity(userCart.getQuantity());
			cartRepository.saveAndFlush(cart);
			return "Added to cart successfully";
		}
		Cart cart = new Cart();
		cart.setQuantity(userCart.getQuantity());
		cart.setProduct(productRepository.findById(userCart.getProductId()).get());
		cart.setUser(userRepository.findById(userCart.getUserId()).get());
		Cart c =  cartRepository.save(cart);
		System.out.println(c);
		if(c !=null) {
			return "Added to cart successfully";
		}
		return "Error adding to cart";
		
	}
}
