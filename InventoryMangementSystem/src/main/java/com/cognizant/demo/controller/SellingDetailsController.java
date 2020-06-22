package com.cognizant.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.entity.SellingDetails;
import com.cognizant.demo.exception.FinishedProductNotFoundException;
import com.cognizant.demo.exception.OutOfStockException;
import com.cognizant.demo.model.SellingProducts;
import com.cognizant.demo.service.SellingDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"SellingDetails Entity"})
@RestController
@RequestMapping("/inventory")
public class SellingDetailsController {
	
	private static Logger LOGGER=LoggerFactory.getLogger(SellingDetailsController.class);

	@Autowired
	SellingDetailsService sellingDetailsService;
	
	@ApiOperation(value="selling Details",notes="")
	@PostMapping("/selling")
	public SellingDetails getSellingDetails(@RequestBody List<SellingProducts> sellingProductsList) throws FinishedProductNotFoundException, OutOfStockException {
		LOGGER.debug("Inside SellingDetailsController.getSellingDetails() method");
		return sellingDetailsService.getSellingDetails(sellingProductsList);
	}
}
