package com.cognizant.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.entity.RawMaterials;
import com.cognizant.demo.service.RawMaterialService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"RawMaterials Entity"})
@RestController
@RequestMapping("/inventory")
public class RawMaterialsController {
	
	private static Logger LOGGER=LoggerFactory.getLogger(RawMaterialsController.class);

	@Autowired
	RawMaterialService rawMaterialService;
	
	@ApiOperation(value="Add Raw Material",notes="")
	@PostMapping("/rawMaterials/add")
	public void addRawMaterilas(@RequestBody RawMaterials rawMaterials) {
		LOGGER.debug("Inside RawMaterialsController.addRawMaterilas() method");
		rawMaterialService.addRawMaterials(rawMaterials);
	}
	
	@ApiOperation(value="Get Raw Materials",notes="")
	@GetMapping("/rawmaterials")
	public List<RawMaterials> getAllRawMaterilas(){
		LOGGER.debug("Inside RawMaterialsController.getAllRawMaterilas() method");
		return rawMaterialService.getAllRawMaterials();
	}
	
}
