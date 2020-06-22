package com.cognizant.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.demo.entity.FinishedProducts;

@Repository
public interface FinishedProductsRepository extends JpaRepository<FinishedProducts, Integer> {

	FinishedProducts findByProductName(String productname);
	
}
