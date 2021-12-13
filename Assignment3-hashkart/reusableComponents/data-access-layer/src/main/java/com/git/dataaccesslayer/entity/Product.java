package com.git.dataaccesslayer.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="pt_id")
	private int id;
	
	@Column(name="name")
	private String productName;
	
	@Column(name="pt_type")
	private String product_type;
	
	@Column(name="price_per_quantity")
	private int price;
	
	@Column(name="quantity_available")
	private int quantityAvailable;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="brand")
	private String brand;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="Category_id")
	private Category category;

	public Product() {
		super();
	}

	public Product(int id, String productName, String product_type, int price, int quantityAvailable, int rating,
			String brand, Category category) {
		super();
		this.id = id;
		this.productName = productName;
		this.product_type = product_type;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
		this.rating = rating;
		this.brand = brand;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", product_type=" + product_type + ", price="
				+ price + ", quantityAvailable=" + quantityAvailable + ", rating=" + rating + ", brand=" + brand
				+ ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, category, id, price, productName, product_type, quantityAvailable, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return brand == other.brand && Objects.equals(category, other.category) && id == other.id
				&& price == other.price && Objects.equals(productName, other.productName)
				&& Objects.equals(product_type, other.product_type) && quantityAvailable == other.quantityAvailable
				&& rating == other.rating;
	}
	
	
	
	
}
