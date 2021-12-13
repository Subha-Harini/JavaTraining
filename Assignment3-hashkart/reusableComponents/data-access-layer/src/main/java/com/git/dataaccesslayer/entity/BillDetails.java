package com.git.dataaccesslayer.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill_details")
public class BillDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_d_id")
	int billDetailsId;
	
	@Column(name = "Bill_b_id")
	int billId;
	
	@Column(name = "Product_pt_id")
	int productCode;
	
	@Column(name = "purchased_quantity")
	int quantity;

	public BillDetails() {
		super();
	}

	public BillDetails( int billId, int productCode, int quantity) {
		super();
		this.billDetailsId = billDetailsId;
		this.billId = billId;
		this.productCode = productCode;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BillDetails [billDetailsId=" + billDetailsId + ", billId=" + billId + ", productCode=" + productCode
				+ ", quantity=" + quantity + "]";
	}

	public int getBillDetailsId() {
		return billDetailsId;
	}

	public void setBillDetailsId(int billDetailsId) {
		this.billDetailsId = billDetailsId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(billDetailsId, billId, productCode, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillDetails other = (BillDetails) obj;
		return billDetailsId == other.billDetailsId && billId == other.billId && productCode == other.productCode
				&& quantity == other.quantity;
	}
	
	

}
