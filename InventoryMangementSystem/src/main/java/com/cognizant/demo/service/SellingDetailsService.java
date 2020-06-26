package com.cognizant.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.entity.FinishedProducts;
import com.cognizant.demo.entity.SellingDetails;
import com.cognizant.demo.exception.FinishedProductNotFoundException;
import com.cognizant.demo.exception.OutOfStockException;
import com.cognizant.demo.model.SellingProducts;
import com.cognizant.demo.repository.FinishedProductsRepository;
import com.cognizant.demo.repository.SellingDetailsRepository;

@Service
public class SellingDetailsService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(SellingDetailsService.class);

	@Autowired
	SellingDetailsRepository sellingDetailsRepository;

	@Autowired
	FinishedProductsRepository finishedProductsRepository;
	
	@Transactional
	public SellingDetails getSellingDetails(List<SellingProducts> sellingProductsList)
			throws FinishedProductNotFoundException, OutOfStockException {
		LOGGER.debug("Inside SellingDetailsService.getSellingDetails() method");
		long costOfSelling = 0;
		List<FinishedProducts> finishedProductsList = new ArrayList<FinishedProducts>();
		for (SellingProducts sellingProduct : sellingProductsList) {

			FinishedProducts finishedProducts = finishedProductsRepository
					.findByProductName(sellingProduct.getProductName());
			if (finishedProducts != null) {
				if (finishedProducts.getQuantity() - sellingProduct.getQuantity() >= 0) {
					finishedProducts.setQuantity(finishedProducts.getQuantity() - sellingProduct.getQuantity());
				}else
					throw new OutOfStockException();
				finishedProductsList.add(finishedProducts);
				costOfSelling = costOfSelling + finishedProducts.getCostPerProduct() * sellingProduct.getQuantity();
			} else
				throw new FinishedProductNotFoundException();
		}
		SellingDetails sellingDetails = new SellingDetails();
		sellingDetails.setDateOfSelling(new Date());
		sellingDetails.setFinishedProductsList(finishedProductsList);
		sellingDetails.setTotalCost(costOfSelling);
		sellingDetailsRepository.save(sellingDetails);
		return sellingDetails;
	}

}
