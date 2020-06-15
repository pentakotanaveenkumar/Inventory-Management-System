package com.example.demo.entity;

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
@Table(name="product_details")
public class SellingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="date_of_selling")
	private Date dateOfSelling;
	
	@Column(name="totalCost")
	private long totalCost;
	
	@ManyToMany
	@JoinTable(
	        name = "selling_details_finished_product", 
	        joinColumns = { @JoinColumn(name = "selling_details_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "finished_products_id") }
	    )
	List<FinishedProducts> finishedProductsList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfSelling() {
		return dateOfSelling;
	}

	public void setDateOfSelling(Date dateOfSelling) {
		this.dateOfSelling = dateOfSelling;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}

	public List<FinishedProducts> getFinishedProductsList() {
		return finishedProductsList;
	}

	public void setFinishedProductsList(List<FinishedProducts> finishedProductsList) {
		this.finishedProductsList = finishedProductsList;
	}
	
	
	
	
}
