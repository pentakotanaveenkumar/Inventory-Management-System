package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Stock;
import com.example.demo.exception.RawMaterialsNotFoundException;
import com.example.demo.service.StockService;

@RestController
@RequestMapping("inventory")
public class StockController {
	@Autowired
	StockService stockService;

	@GetMapping("/stock")
	public List<Stock> getAllRawMaterialsInStock(){
		
		return stockService.getAllRawMaterialsInStock();
	}

	@DeleteMapping("/stock")
	public void deleteRawMaterials(@RequestParam(name="name") String name) throws RawMaterialsNotFoundException {
		stockService.deleteRawMaterials(name);
	}
}
