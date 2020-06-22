package com.cognizant.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.entity.FinishedProducts;
import com.cognizant.demo.model.FinishedProductsDetails;
import com.cognizant.demo.repository.FinishedProductsRepository;

@Service
public class FinishedProductsService {
	
	private static Logger LOGGER=LoggerFactory.getLogger(FinishedProductsService.class);

	@Autowired
	FinishedProductsRepository finishedProductsRepository;
	
	@Transactional
	public List<FinishedProducts> getAllFinishedProducts() {
		LOGGER.debug("inside getAllFinishedProducts() method");
		return finishedProductsRepository.findAll();
	}
	
	@Transactional
	public void addFinishedProducts(List<FinishedProductsDetails> finishedProductsDetailsList) {
		LOGGER.debug("inside addFinishedProducts() method");
		for (FinishedProductsDetails finishedProductsDetails : finishedProductsDetailsList) {
			FinishedProducts finishedProducts = finishedProductsRepository
					.findByProductName(finishedProductsDetails.getProductName());
			if (finishedProducts != null) {
				finishedProducts.setQuantity(finishedProducts.getQuantity() + finishedProductsDetails.getQuantity());
				if (finishedProducts.getCostPerProduct() < finishedProductsDetails.getCost())
					finishedProducts.setCostPerProduct(finishedProductsDetails.getCost());
			} else {
				FinishedProducts finishedProductsNew = new FinishedProducts();
				finishedProductsNew.setProductName(finishedProductsDetails.getProductName());
				finishedProductsNew.setCostPerProduct(finishedProductsDetails.getCost());
				finishedProductsNew.setQuantity(finishedProductsDetails.getQuantity());
				finishedProductsRepository.save(finishedProductsNew);
			}
		}
	}
}
