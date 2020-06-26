package com.cognizant.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="raw_materials")
public class RawMaterials {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true,name="material_name")
	private String name;
	
	@Column(name="cost")
	private long cost;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public RawMaterials(int id, String name, long cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}

	public RawMaterials() {
		super();
	}

	@Override
	public String toString() {
		return "RawMaterials [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}

}
