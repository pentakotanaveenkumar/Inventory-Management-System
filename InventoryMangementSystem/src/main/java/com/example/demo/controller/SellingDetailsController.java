package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SellingDetails;
import com.example.demo.exception.FinishedProductNotFoundException;
import com.example.demo.exception.OutOfStockException;
import com.example.demo.model.SellingProducts;
import com.example.demo.service.SellingDetailsService;

@RestController
@RequestMapping("/inventory")
public class SellingDetailsController {

	@Autowired
	SellingDetailsService sellingDetailsService;
	
	@PostMapping("/selling")
	public SellingDetails sellingDetails(@RequestBody List<SellingProducts> sellingProductsList) throws FinishedProductNotFoundException, OutOfStockException {
		return sellingDetailsService.sellingDetails(sellingProductsList);
	}
}
