package com.cognizant.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="purchase_details")
public class PurchaseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="date_of_purchase")
	private Date dateOfPurchase;
	
	@Column(name="totalCost")
	private long totalCost;
	
	@ManyToMany
	@JoinTable(
	        name = "purchase_details_rawmaterails", 
	        joinColumns = { @JoinColumn(name = "purchase_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "rawmaterials_id") }
	    )
	List<RawMaterials> rawMaterialList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public long getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}
	public List<RawMaterials> getRawMaterialList() {
		return rawMaterialList;
	}
	public void setRawMaterialList(List<RawMaterials> rawMaterialList) {
		this.rawMaterialList = rawMaterialList;
	}
	public PurchaseDetails() {
		super();
	}
	public PurchaseDetails(Date dateOfPurchase, long totalCost, List<RawMaterials> rawMaterialList) {
		super();
		this.dateOfPurchase = dateOfPurchase;
		this.totalCost = totalCost;
		this.rawMaterialList = rawMaterialList;
	}
	@Override
	public String toString() {
		return "PurchaseDetails [id=" + id + ", dateOfPurchase=" + dateOfPurchase + ", totalCost=" + totalCost
				+ ", rawMaterialList=" + rawMaterialList + "]";
	}
}
