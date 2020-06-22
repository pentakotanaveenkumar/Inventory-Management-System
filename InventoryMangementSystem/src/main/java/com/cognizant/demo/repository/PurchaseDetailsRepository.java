package com.cognizant.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.demo.entity.PurchaseDetails;

@Repository
public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Integer> {

}
