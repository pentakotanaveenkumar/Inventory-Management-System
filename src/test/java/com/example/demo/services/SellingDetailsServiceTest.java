package com.example.demo.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.entity.FinishedProducts;
import com.example.demo.exception.FinishedProductNotFoundException;
import com.example.demo.exception.OutOfStockException;
import com.example.demo.model.SellingProducts;
import com.example.demo.repository.FinishedProductsRepository;
import com.example.demo.repository.SellingDetailsRepository;
import com.example.demo.service.SellingDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class SellingDetailsServiceTest {
	@Mock
	SellingDetailsRepository sellingDetailsRepository;
	
	@Mock
	FinishedProductsRepository finishedProductsRepository;
	
	@InjectMocks
	SellingDetailsService sellingDetailsService;
	
	@Test
	public void testSellingDetails() throws FinishedProductNotFoundException, OutOfStockException {
		List<SellingProducts> sellingProductsList=new ArrayList<SellingProducts>();
		sellingProductsList.add(new SellingProducts("chair", 2));		
		when(finishedProductsRepository.findByProductName("chair")).thenReturn(new FinishedProducts(1, "chair", 1500, 6));
		assertEquals(3000, sellingDetailsService.sellingDetails(sellingProductsList).getTotalCost());
		
		
	}

}
