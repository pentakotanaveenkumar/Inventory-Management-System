package com.cognizant.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.entity.RawMaterials;
import com.cognizant.demo.repository.RawMaterialsRepository;

@Service
public class RawMaterialService {
	
	private static Logger LOGGER=LoggerFactory.getLogger(RawMaterialService.class);
	
	@Autowired
	RawMaterialsRepository rawMaterialsRepository;
	
	@Transactional
	public List<RawMaterials> getAllRawMaterials(){
		LOGGER.debug("Inside RawMaterialService.getAllRawMaterials() method");
		return rawMaterialsRepository.findAll();
	}
	
	@Transactional
	public void addRawMaterials(RawMaterials rawMaterials) {
		LOGGER.debug("Inside RawMaterialService.getAllRawMaterials() method");
		rawMaterialsRepository.save(rawMaterials);
	}

}
