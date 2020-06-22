package com.cognizant.demo.model;

public class OrderingMaterials {

	private String name;
	private int quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderingMaterials(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	public OrderingMaterials() {
		super();
	}
	
}
