package com.cognizant.demo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.demo.entity.FinishedProducts;
import com.cognizant.demo.model.FinishedProductsDetails;
import com.cognizant.demo.repository.FinishedProductsRepository;
import com.cognizant.demo.service.FinishedProductsService;

@RunWith(MockitoJUnitRunner.class)
public class FinishedProductsServiceTest {
	@Mock
	FinishedProductsRepository finishedProductsRepository;
	
	@InjectMocks
	FinishedProductsService finishedProductsService;

	@Test
	public void testGetAllFinishedProducts() {
		List<FinishedProducts> finishedProductsList=new ArrayList<FinishedProducts>();
		finishedProductsList.add(new FinishedProducts(1, "chair", 1500, 3));
		finishedProductsList.add(new FinishedProducts(2, "bed", 2500, 6));
		
		when(finishedProductsRepository.findAll()).thenReturn(finishedProductsList);
		
		assertEquals(finishedProductsList.size(), finishedProductsService.getAllFinishedProducts().size());
	}
	
	
	@Test
	public void testAddFinishedProducts() {
		List<FinishedProductsDetails> finishedProductsDetailsList=new ArrayList<FinishedProductsDetails>();
		FinishedProductsDetails finishedProductsDetails=new FinishedProductsDetails("chair", 2, 1500);
		finishedProductsDetailsList.add(finishedProductsDetails);
		FinishedProducts finishedProducts=new FinishedProducts(1, "chair", 1500, 3);
		List<FinishedProducts> finishedProductsList=new ArrayList<FinishedProducts>();
		finishedProductsList.add(finishedProducts);
		finishedProductsList.add(new FinishedProducts(2, "bed", 2500, 6));
		verify(finishedProductsRepository,never()).save(finishedProducts);	
	}

}
