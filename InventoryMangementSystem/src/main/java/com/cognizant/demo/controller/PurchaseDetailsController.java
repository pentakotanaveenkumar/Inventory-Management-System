package com.cognizant.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.entity.PurchaseDetails;
import com.cognizant.demo.exception.RawMaterialsNotFoundException;
import com.cognizant.demo.model.OrderingMaterials;
import com.cognizant.demo.service.PurchaseDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"PurchaseDetails Entity"})
@RestController
@RequestMapping("/inventory")
public class PurchaseDetailsController {

	private static final Logger LOGGER=LoggerFactory.getLogger(PurchaseDetailsController.class);
	
	@Autowired
	PurchaseDetailsService purchaseDetailsService;
	
	@ApiOperation(value="Get Purchase Details",notes="")
	@PostMapping("/purchase")
	public PurchaseDetails getPurchaseDetails(@RequestBody List<OrderingMaterials> rawMaterialList) throws RawMaterialsNotFoundException {
		LOGGER.debug("Inside PurchaseDetailsController.getPurchaseDetails() method");
		return purchaseDetailsService.getPurchaseDetails(rawMaterialList);
	}
}
