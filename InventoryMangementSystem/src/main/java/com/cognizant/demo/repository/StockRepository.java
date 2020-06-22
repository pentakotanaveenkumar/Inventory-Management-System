package com.cognizant.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.demo.entity.RawMaterials;
import com.cognizant.demo.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
	
	Stock findByRawMaterials(RawMaterials rawmaterials);
}
