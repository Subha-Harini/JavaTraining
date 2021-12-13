package com.git.dataaccesslayer.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@Column(name = "b_id")
	private int id;
	
	@Column(name = "purchase_date")
	private Date purchaseDate;
	
	@Column(name = "total_amount")
	private int totalAmount;
	
	@Column(name = "discount_percent")
	private int discountPercent;
	
	@Column(name = "payment_status")
	private String paymentStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="User_id")
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="bill_b_id")
	private List<BillDetails> billDetailsList;

	public List<BillDetails> getBillDetailsList() {
		return billDetailsList;
	}

	public void setBillDetailsList(List<BillDetails> billDetailsList) {
		this.billDetailsList = billDetailsList;
	}

	public Bill() {
		super();
	}

	public Bill(int id, Date purchaseDate, int totalAmount, int discountPercent, String paymentStatus, User user) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.totalAmount = totalAmount;
		this.discountPercent = discountPercent;
		this.paymentStatus = paymentStatus;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", purchaseDate=" + purchaseDate + ", totalAmount=" + totalAmount
				+ ", discountPercent=" + discountPercent + ", paymentStatus=" + paymentStatus + ", user=" + user + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(discountPercent, id, paymentStatus, purchaseDate, totalAmount, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		return discountPercent == other.discountPercent && id == other.id
				&& Objects.equals(paymentStatus, other.paymentStatus)
				&& Objects.equals(purchaseDate, other.purchaseDate) && totalAmount == other.totalAmount
				&& Objects.equals(user, other.user);
	}
	
	
}
