package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RawMaterials;
import com.example.demo.repository.RawMaterialsRepository;

@Service
public class RawMaterialService {

	@Autowired
	RawMaterialsRepository rawMaterialsRepository;
	
	public List<RawMaterials> getAllRawMaterials(){
		return rawMaterialsRepository.findAll();
	}

	public void addRawMaterials(RawMaterials rawMaterials) {
		rawMaterialsRepository.save(rawMaterials);
	}
	
	
}
