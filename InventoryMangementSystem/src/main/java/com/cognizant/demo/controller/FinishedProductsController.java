package com.cognizant.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.entity.FinishedProducts;
import com.cognizant.demo.model.FinishedProductsDetails;
import com.cognizant.demo.service.FinishedProductsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"FinishedProducts Entity"})
@RestController
@RequestMapping("/inventory")
public class FinishedProductsController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(FinishedProductsController.class);
	
	@Autowired
	FinishedProductsService finishedProductsService;
	
	@ApiOperation(value="Get Finished Products",notes="")
	@GetMapping("/finishedproducts")
	@Cacheable(value="finishedProducts")
	public List<FinishedProducts> getAllFinishedProducts(){
		LOGGER.debug("Inside FinishedProductsController.getAllFinishedProducts() method");
		return finishedProductsService.getAllFinishedProducts();
	}
	
	@ApiOperation(value="Add Finished Products",notes="")
	@PostMapping("/finishedproducts/update")
	public void addFinishedProducts(@RequestBody List<FinishedProductsDetails> finishedProductsDetailsList) {
		LOGGER.debug("Inside FinishedProductsController.addFinishedProducts() method");
		finishedProductsService.addFinishedProducts(finishedProductsDetailsList);
	}
}
