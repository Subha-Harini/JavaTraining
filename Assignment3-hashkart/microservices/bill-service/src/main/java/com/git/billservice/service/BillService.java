package com.git.billservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.IntBinaryOperator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.git.dataaccesslayer.entity.Bill;
import com.git.dataaccesslayer.entity.BillDetails;
import com.git.dataaccesslayer.entity.Cart;
import com.git.dataaccesslayer.entity.Product;
import com.git.dataaccesslayer.entity.ProductList;
import com.git.dataaccesslayer.entity.UserBill;
import com.git.dataaccesslayer.repository.BillRepository;
import com.git.dataaccesslayer.repository.CartRepository;
import com.git.dataaccesslayer.repository.ProductRepository;
import com.git.dataaccesslayer.repository.UserRepository;

@Service
public class BillService {
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Value("${discountPercent}")
	private int discountPercent ;
	
	public String userBills(UserBill userBill)  {
		System.out.println(userBill);
		Bill bill = new Bill();
		int billId;
		try {
			System.out.println(billRepository.findMaximunBillId());
			billId = billRepository.findMaximunBillId();
		}catch(NullPointerException e) {
			billId=0;
		}
		billId++;
		bill.setId(billId);
		bill.setDiscountPercent(discountPercent);
		bill.setUser(
				userRepository.findById(
						userBill.getUserId()
						).get());
		bill.setPurchaseDate(new Date());
		bill.setPaymentStatus("Payment successful");
		List<Product> productList = new ArrayList();
		List<BillDetails> billDetailsList = new ArrayList<BillDetails>();
		float totalAmount = 0;
		for(ProductList product : userBill.getProductList()) {
			//get prouduct details based on product id
			Product p = productRepository.findById(
					product.getProductId()).
					get();
			//adding product to bill product list
			productList.add(p);
			//reduce quantity in product table
			int quantityAvailable = p.getQuantityAvailable();
			p.setQuantityAvailable(quantityAvailable - product.getQuantity());
			// calculate total amount based on discount
			totalAmount += (((p.getPrice() * (100 - discountPercent)) / 100) )* product.getQuantity();
			billDetailsList.add(new BillDetails(billId, p.getId(), product.getQuantity()));
			//remove product from user cart
			System.out.println(cartRepository.findByUserAndProduct(userBill.getUserId(),product.getProductId()));
			if(cartRepository.findByUserAndProduct(userBill.getUserId(),product.getProductId()) != null) {
				Cart cart= cartRepository.findByUserAndProduct(userBill.getUserId(),product.getProductId());
				cartRepository.deleteById(cart.getId());
			}
		}
		bill.setTotalAmount((int) totalAmount);
		bill.setBillDetailsList(billDetailsList);
		System.out.println(billDetailsList);
		System.out.println(bill);
		Bill generatedBill = billRepository.save(bill);
		if(generatedBill != null) {
			return "Bill generated successfully";
		}
		return "Error in generating bill";
		
	}
}
