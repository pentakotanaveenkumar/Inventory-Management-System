package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RawMaterials;
import com.example.demo.entity.Stock;
import com.example.demo.exception.RawMaterialsNotFoundException;
import com.example.demo.repository.RawMaterialsRepository;
import com.example.demo.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	RawMaterialsRepository rawMaterialsRepository;

	public List<Stock> getAllRawMaterialsInStock() {
		return stockRepository.findAll();
	}

	public void deleteRawMaterials(String name) throws RawMaterialsNotFoundException {
		RawMaterials rawMaterials=rawMaterialsRepository.findByName(name);
		
		Stock stock=stockRepository.findByRawMaterials(rawMaterials);
		if(stock!=null) {
		stockRepository.delete(stock);
		}else
			throw new RawMaterialsNotFoundException();
	}

}
