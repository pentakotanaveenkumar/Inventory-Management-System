package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FinishedProducts;
import com.example.demo.entity.SellingDetails;
import com.example.demo.exception.FinishedProductNotFoundException;
import com.example.demo.exception.OutOfStockException;
import com.example.demo.model.SellingProducts;
import com.example.demo.repository.FinishedProductsRepository;
import com.example.demo.repository.SellingDetailsRepository;

@Service
public class SellingDetailsService {

	@Autowired
	SellingDetailsRepository sellingDetailsRepository;

	@Autowired
	FinishedProductsRepository finishedProductsRepository;

	public SellingDetails sellingDetails(List<SellingProducts> sellingProductsList)
			throws FinishedProductNotFoundException, OutOfStockException {
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
