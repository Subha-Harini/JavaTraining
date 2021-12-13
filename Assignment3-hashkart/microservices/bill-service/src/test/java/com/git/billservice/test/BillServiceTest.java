package com.git.billservice.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.git.billservice.service.BillService;
import com.git.billservice.service.CartService;
import com.git.dataaccesslayer.entity.Bill;
import com.git.dataaccesslayer.entity.Cart;
import com.git.dataaccesslayer.entity.Product;
import com.git.dataaccesslayer.entity.ProductList;
import com.git.dataaccesslayer.entity.User;
import com.git.dataaccesslayer.entity.UserBill;
import com.git.dataaccesslayer.entity.UserCart;
import com.git.dataaccesslayer.repository.BillRepository;
import com.git.dataaccesslayer.repository.CartRepository;
import com.git.dataaccesslayer.repository.ProductRepository;
import com.git.dataaccesslayer.repository.UserRepository;

@ExtendWith(SpringExtension.class)
public class BillServiceTest {
	
	@InjectMocks
	BillService billService;
	
	@InjectMocks
	CartService cartService;
	
	@Mock
	UserCart userCart;
	
	@Mock
	BillRepository billRepository;
	
	@Mock
	CartRepository cartRepository;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	ProductRepository productRepository;
	
	@Mock
	UserBill userBill;
	
	@Mock
	User user;
	
	@Mock
	Product product;
	
	@Mock
	ProductList prodList;
	
	@Mock
	Cart cart;
	
	@Mock
	Bill bill;
	
	@Test
	public void userBillsTest() {
		List prodLs = new ArrayList();
		prodLs.add(prodList);
		Cart ca =null;
		Optional userOp = Optional.of(user);
		Optional ProdOp = Optional.of(product);
		when(userRepository.findById(Mockito.any())).thenReturn(userOp);
		when(userBill.getProductList()).thenReturn(prodLs);
		when(productRepository.findById(Mockito.any())).thenReturn(ProdOp);
		billService.userBills(userBill);
	}
	
	@Test
	public void userBillsNullPtrExpTest() {
		List prodLs = new ArrayList();
		prodLs.add(prodList);
		Optional userOp = Optional.of(user);
		Optional ProdOp = Optional.of(product);
		when(billRepository.findMaximunBillId()).thenThrow(new NullPointerException());
		when(userRepository.findById(Mockito.any())).thenReturn(userOp);
		when(userBill.getProductList()).thenReturn(prodLs);
		when(productRepository.findById(Mockito.any())).thenReturn(ProdOp);
		billService.userBills(userBill);
	}
	
	@Test
	public void userBillsIfCartTest() {
		List prodLs = new ArrayList();
		prodLs.add(prodList);
		Optional userOp = Optional.of(user);
		Optional ProdOp = Optional.of(product);
		when(userRepository.findById(Mockito.any())).thenReturn(userOp);
		when(userBill.getProductList()).thenReturn(prodLs);
		when(productRepository.findById(Mockito.any())).thenReturn(ProdOp);
		when(cartRepository.findByUserAndProduct(Mockito.anyString(), Mockito.anyInt())).thenReturn(cart);
		billService.userBills(userBill);
	}
	
		@Test
		public void userBillifGenTest() {
			List prodLs = new ArrayList();
			prodLs.add(prodList);
			Optional userOp = Optional.of(user);
			Optional ProdOp = Optional.of(product);
			when(userRepository.findById(Mockito.any())).thenReturn(userOp);
			when(userBill.getProductList()).thenReturn(prodLs);
			when(productRepository.findById(Mockito.any())).thenReturn(ProdOp);
			when( billRepository.save(Mockito.any())).thenReturn(bill);
			billService.userBills(userBill);
		}
		
		
}
