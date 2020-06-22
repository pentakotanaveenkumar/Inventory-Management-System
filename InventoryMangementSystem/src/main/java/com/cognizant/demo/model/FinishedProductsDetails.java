package com.cognizant.demo.model;

public class FinishedProductsDetails {

	private String productName;
	private int quantity;
	private long cost;

	public String getProductName() {
		return productName;
	}
	
	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public FinishedProductsDetails(String productName, int quantity, long cost) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.cost = cost;
	}

	public FinishedProductsDetails() {
		super();
	}
	
}
