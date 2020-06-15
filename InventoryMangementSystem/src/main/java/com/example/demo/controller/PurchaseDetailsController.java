package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PurchaseDetails;
import com.example.demo.exception.RawMaterialsNotFoundException;
import com.example.demo.model.OrderingMaterials;
import com.example.demo.service.PurchaseDetailsService;

@RestController
@RequestMapping("/inventory")
public class PurchaseDetailsController {

	@Autowired
	PurchaseDetailsService purchaseDetailsService;
	
	@PostMapping("/purchase")
	public PurchaseDetails purchaseDetails(@RequestBody List<OrderingMaterials> rawMaterialList) throws RawMaterialsNotFoundException {
		return purchaseDetailsService.purchaseDetails(rawMaterialList);
	}
}
