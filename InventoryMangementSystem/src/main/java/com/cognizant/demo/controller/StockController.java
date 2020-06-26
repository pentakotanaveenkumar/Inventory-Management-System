package com.cognizant.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.entity.Stock;
import com.cognizant.demo.exception.RawMaterialsNotFoundException;
import com.cognizant.demo.service.StockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"Stock Entity"})
@RestController
@RequestMapping("/inventory")
public class StockController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(StockController.class);
	
	@Autowired
	StockService stockService;
	
	@ApiOperation(value="Get Stock",notes="")
	@GetMapping("/stock")
	public List<Stock> getAllRawMaterialsInStock(){
		LOGGER.debug("Inside StockController.getAllRawMaterialsInStock() method");
		return stockService.getAllRawMaterialsInStock();
	}
	
	@ApiOperation(value="Delete Stock",notes="")
	@DeleteMapping("/stock")
	public void deleteRawMaterials(@RequestParam(name="name") String name) throws RawMaterialsNotFoundException {
		LOGGER.debug("Inside StockController.deleteRawMaterials() method");
		stockService.deleteRawMaterials(name);
	}
}
