package com.git.billservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.git.billservice.service.CartService;
import com.git.dataaccesslayer.entity.Cart;
import com.git.dataaccesslayer.entity.Product;
import com.git.dataaccesslayer.entity.UserCart;

@RestController
@RequestMapping("/hashkart/cart")
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping
	public String addToCart(@RequestBody UserCart cart) {
		return cartService.addToCart(cart);
	}

}
