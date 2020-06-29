package com.cognizant.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.entity.RawMaterials;
import com.cognizant.demo.entity.Stock;
import com.cognizant.demo.exception.RawMaterialsNotFoundException;
import com.cognizant.demo.repository.RawMaterialsRepository;
import com.cognizant.demo.repository.StockRepository;


@Service
public class StockService {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(StockService.class);
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	RawMaterialsRepository rawMaterialsRepository;
	
	@Transactional
	public List<Stock> getAllRawMaterialsInStock() {
		LOGGER.debug("Inside StockService.getAllRawMaterialsInStock() method");
		return stockRepository.findAll();
	}
	
	@Transactional
	public void deleteRawMaterials(String name) throws RawMaterialsNotFoundException {
		LOGGER.debug("Inside StockService.deleteRawMaterials() method");
		RawMaterials rawMaterials=rawMaterialsRepository.findByName(name);
		Stock stock=stockRepository.findByRawMaterials(rawMaterials);
		if(stock!=null) {
		stockRepository.delete(stock);
		}else
		
		throw new RawMaterialsNotFoundException();
	}

}
