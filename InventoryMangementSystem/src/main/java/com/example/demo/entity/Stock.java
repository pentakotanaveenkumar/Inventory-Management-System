package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="quantity")
	private int quantity;
	
	@OneToOne
	private RawMaterials rawMaterials;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public RawMaterials getRawMaterials() {
		return rawMaterials;
	}

	public void setRawMaterials(RawMaterials rawMaterials) {
		this.rawMaterials = rawMaterials;
	}

	public Stock(int id, int quantity, RawMaterials rawMaterials) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.rawMaterials = rawMaterials;
	}

	public Stock() {
		super();
	}
	
}
