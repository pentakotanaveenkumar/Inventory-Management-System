package com.cognizant.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.entity.PurchaseDetails;
import com.cognizant.demo.entity.RawMaterials;
import com.cognizant.demo.entity.Stock;
import com.cognizant.demo.exception.RawMaterialsNotFoundException;
import com.cognizant.demo.model.OrderingMaterials;
import com.cognizant.demo.repository.PurchaseDetailsRepository;
import com.cognizant.demo.repository.RawMaterialsRepository;
import com.cognizant.demo.repository.StockRepository;

@Service
public class PurchaseDetailsService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PurchaseDetailsService.class);

	@Autowired
	RawMaterialsRepository rawMaterialsRepository;

	@Autowired
	StockRepository stockRepository;

	@Autowired
	PurchaseDetailsRepository purchaseDetailsRepository;
	
	@Transactional
	public PurchaseDetails getPurchaseDetails(List<OrderingMaterials> orderingMaterialList) throws RawMaterialsNotFoundException {
		LOGGER.debug("Inside PurchaseDetailsService.getPurchaseDetails() method");
		long cost = 0;
		List<RawMaterials> rawMaterialsList = new ArrayList<RawMaterials>();
		for (OrderingMaterials oderingMaterial : orderingMaterialList) {
			RawMaterials rawMaterials = rawMaterialsRepository.findByName(oderingMaterial.getName());
			if (rawMaterials != null) {
				Stock stock = stockRepository.findByRawMaterials(rawMaterials);
				if (stock != null) {
					stock.setQuantity(oderingMaterial.getQuantity() + stock.getQuantity());
				} else {
					Stock stockNew = new Stock();
					stockNew.setQuantity(oderingMaterial.getQuantity());
					stockNew.setRawMaterials(rawMaterials);
					stockRepository.save(stockNew);
				}
				cost = cost + rawMaterials.getCost() * oderingMaterial.getQuantity();
				rawMaterialsList.add(rawMaterials);
			}else
				throw new RawMaterialsNotFoundException();
		}
		PurchaseDetails purchaseDetails = new PurchaseDetails();
		purchaseDetails.setDateOfPurchase(new Date());
		purchaseDetails.setRawMaterialList(rawMaterialsList);
		purchaseDetails.setTotalCost(cost);
		purchaseDetailsRepository.save(purchaseDetails);
		return purchaseDetails;
	}
}
