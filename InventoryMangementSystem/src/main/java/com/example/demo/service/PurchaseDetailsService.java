package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseDetails;
import com.example.demo.entity.RawMaterials;
import com.example.demo.entity.Stock;
import com.example.demo.exception.RawMaterialsNotFoundException;
import com.example.demo.model.OrderingMaterials;
import com.example.demo.repository.PurchaseDetailsRepository;
import com.example.demo.repository.RawMaterialsRepository;
import com.example.demo.repository.StockRepository;

@Service
public class PurchaseDetailsService {

	@Autowired
	RawMaterialsRepository rawMaterialsRepository;

	@Autowired
	StockRepository stockRepository;

	@Autowired
	PurchaseDetailsRepository purchaseDetailsRepository;

	public PurchaseDetails purchaseDetails(List<OrderingMaterials> orderingMaterialList) throws RawMaterialsNotFoundException {
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
