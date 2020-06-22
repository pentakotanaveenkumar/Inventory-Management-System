package com.cognizant.demo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.demo.entity.RawMaterials;
import com.cognizant.demo.entity.Stock;
import com.cognizant.demo.exception.RawMaterialsNotFoundException;
import com.cognizant.demo.repository.RawMaterialsRepository;
import com.cognizant.demo.repository.StockRepository;
import com.cognizant.demo.service.StockService;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceTest {
	
	@Mock
	StockRepository stockRepository;
	
	@Mock
	RawMaterialsRepository rawMaterialsRepository;
	
	@InjectMocks
	StockService stockService;
	
	@Test
	public void testGetAllRawMaterialsInStock_ComparesSize() {
		List<Stock> stockList=new ArrayList<Stock>();
		stockList.add(new Stock(1, 4, new RawMaterials(1, "wood", 100l)));
		stockList.add(new Stock(2,3,new RawMaterials(2, "iron", 500)));
		when(stockRepository.findAll()).thenReturn(stockList);
		assertEquals(stockList.size(), stockService.getAllRawMaterialsInStock().size());
	}
	
	@Test
	public void testGetAllRawMaterialsInStock_ComparesQuantity() {
		List<Stock> stockList=new ArrayList<Stock>();
		stockList.add(new Stock(1, 4, new RawMaterials(1, "wood", 100l)));
		stockList.add(new Stock(2,3,new RawMaterials(2, "iron", 500)));
		when(stockRepository.findAll()).thenReturn(stockList);
		assertEquals(stockList.get(1).getQuantity(), stockService.getAllRawMaterialsInStock().get(1).getQuantity());
	}
	
	@Test(expected = RawMaterialsNotFoundException.class)
	public void testDeleteRawMaterials() throws RawMaterialsNotFoundException {
		
		stockService.deleteRawMaterials("name");
		
	}

}
