package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="finishedProduct")
public class FinishedProducts {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true,name="product_name")
	private String productName;
	
	@Column(name="cost_per_product")
	private long costPerProduct;
	
	@Column(name="quantity")
	private int quantity;

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

	public long getCostPerProduct() {
		return costPerProduct;
	}

	public void setCostPerProduct(long costPerProduct) {
		this.costPerProduct = costPerProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public FinishedProducts(int id, String productName, long costPerProduct, int quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.costPerProduct = costPerProduct;
		this.quantity = quantity;
	}

	public FinishedProducts() {
		super();
	}
	
}
