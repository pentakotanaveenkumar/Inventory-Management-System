package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FinishedProducts;
import com.example.demo.model.FinishedProductsDetails;
import com.example.demo.repository.FinishedProductsRepository;

@Service
public class FinishedProductsService {

	@Autowired
	FinishedProductsRepository finishedProductsRepository;

	public List<FinishedProducts> getAllFinishedProducts() {
		return finishedProductsRepository.findAll();
	}

	public void addFinishedProducts(List<FinishedProductsDetails> finishedProductsDetailsList) {
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
