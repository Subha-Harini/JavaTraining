package com.git.dataaccesslayer.entity;

import java.util.List;

public class UserBill {

	private String userId;
	private List<ProductList> productList;
	private int billId;
	public UserBill() {
		super();
	}
	public UserBill(String userId, List<ProductList> productList, int billId) {
		super();
		this.userId = userId;
		this.productList = productList;
		this.billId = billId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + billId;
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBill other = (UserBill) obj;
		if (billId != other.billId)
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<ProductList> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductList> productList) {
		this.productList = productList;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	@Override
	public String toString() {
		return "UserBill [userId=" + userId + ", productList=" + productList + ", billId=" + billId + "]";
	}
	
	
}
