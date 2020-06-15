package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RawMaterials;
import com.example.demo.service.RawMaterialService;

@RestController
@RequestMapping("/inventory")
public class RawMaterialsController {

	@Autowired
	RawMaterialService rawMaterialService;
	
	@PostMapping("/rawmaterials/add")
	public void addRawMaterilas(@RequestBody RawMaterials rawMaterials) {
		rawMaterialService.addRawMaterials(rawMaterials);
	}
	
	@GetMapping("/rawmaterials")
	public List<RawMaterials> getAllRawMaterilas(){
		return rawMaterialService.getAllRawMaterials();
	}
	
}
