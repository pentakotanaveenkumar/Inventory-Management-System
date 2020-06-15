package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FinishedProducts;
import com.example.demo.model.FinishedProductsDetails;
import com.example.demo.service.FinishedProductsService;

@RestController
@RequestMapping("/inventory")
public class FinishedProductsController {
	
	@Autowired
	FinishedProductsService finishedProductsService;
	
	@GetMapping("/finishedproducts")
	public List<FinishedProducts> getAllFinishedProducts(){
		return finishedProductsService.getAllFinishedProducts();
	}
	
	@PostMapping("/finishedproducts/update")
	public void addFinishedProducts(@RequestBody List<FinishedProductsDetails> finishedProductsDetailsList) {
		finishedProductsService.addFinishedProducts(finishedProductsDetailsList);
	}
}
