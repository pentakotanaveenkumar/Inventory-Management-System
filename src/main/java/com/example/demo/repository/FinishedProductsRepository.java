package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FinishedProducts;

@Repository
public interface FinishedProductsRepository extends JpaRepository<FinishedProducts, Integer> {

	FinishedProducts findByProductName(String productname);
	
}
