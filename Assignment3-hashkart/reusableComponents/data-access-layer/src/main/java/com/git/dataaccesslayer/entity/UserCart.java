package com.git.dataaccesslayer.entity;

import java.util.List;

public class UserCart {

	private String userId;
	private int productId;
	private int quantity;
	public UserCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCart(String userId, int productId, int quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "UserCart [userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}
	
	
}
