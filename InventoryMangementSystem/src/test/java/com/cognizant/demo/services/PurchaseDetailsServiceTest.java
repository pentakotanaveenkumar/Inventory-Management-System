package com.cognizant.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.demo.entity.RawMaterials;
import com.cognizant.demo.entity.Stock;
import com.cognizant.demo.exception.RawMaterialsNotFoundException;
import com.cognizant.demo.model.OrderingMaterials;
import com.cognizant.demo.repository.PurchaseDetailsRepository;
import com.cognizant.demo.repository.RawMaterialsRepository;
import com.cognizant.demo.repository.StockRepository;
import com.cognizant.demo.service.PurchaseDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseDetailsServiceTest {

	@Mock
	RawMaterialsRepository rawMaterialsRepository;

	@Mock
	StockRepository stockRepository;

	@Mock
	PurchaseDetailsRepository purchaseDetailsRepository;

	@InjectMocks
	PurchaseDetailsService purchaseDetailsService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testPurchaseDetails() throws RawMaterialsNotFoundException  {
		List<OrderingMaterials> orderingMaterialList=new ArrayList<OrderingMaterials>();
		OrderingMaterials orderingMaterial=new OrderingMaterials();
		orderingMaterial.setName("wood");
		orderingMaterial.setQuantity(2);
		orderingMaterialList.add(orderingMaterial);
		List<RawMaterials> rawMaterialsList = new ArrayList<RawMaterials>();
		
		RawMaterials rawMaterial=new RawMaterials(1,"wood", 200L);
		Stock stock=new Stock(1,2,rawMaterial);
		rawMaterialsList.add(rawMaterial);
		
		when(rawMaterialsRepository.findByName(orderingMaterialList.get(0).getName())).thenReturn(rawMaterial);
		when(stockRepository.findByRawMaterials(rawMaterial)).thenReturn(stock);
		
		assertEquals(400l, purchaseDetailsService.getPurchaseDetails(orderingMaterialList).getTotalCost());
	}
	
	@Test
	public void testPurchaseDetails_getRawMaterials() throws RawMaterialsNotFoundException  {
		List<OrderingMaterials> orderingMaterialList=new ArrayList<OrderingMaterials>();
		OrderingMaterials orderingMaterial=new OrderingMaterials();
		orderingMaterial.setName("wood");
		orderingMaterial.setQuantity(2);
		orderingMaterialList.add(orderingMaterial);
		List<RawMaterials> rawMaterialsList = new ArrayList<RawMaterials>();
		
		RawMaterials rawMaterial=new RawMaterials(1,"wood", 200L);
		Stock stock=new Stock(1,2,rawMaterial);
		rawMaterialsList.add(rawMaterial);
		
		when(rawMaterialsRepository.findByName(orderingMaterialList.get(0).getName())).thenReturn(rawMaterial);
		when(stockRepository.findByRawMaterials(rawMaterial)).thenReturn(stock);
		
		assertEquals(rawMaterialsList, purchaseDetailsService.getPurchaseDetails(orderingMaterialList).getRawMaterialList());
	}
	
}
