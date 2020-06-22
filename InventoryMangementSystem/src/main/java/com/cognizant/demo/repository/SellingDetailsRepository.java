package com.cognizant.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.demo.entity.SellingDetails;

@Repository
public interface SellingDetailsRepository extends JpaRepository<SellingDetails, Integer> {
	
}
