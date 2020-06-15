package com.example.demo.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.entity.RawMaterials;
import com.example.demo.repository.RawMaterialsRepository;
import com.example.demo.service.RawMaterialService;

@RunWith(MockitoJUnitRunner.class)
public class RawMaterialsServiceTest {

	@Mock
	RawMaterialsRepository rawMaterialsRepository;
	
	@InjectMocks
	RawMaterialService rawMaterialService;
	
	@Test
	public void testGetAllRawMaterials() {
		List<RawMaterials> rawMaterialsList=new ArrayList<RawMaterials>();
		rawMaterialsList.add(new RawMaterials(1, "wood", 100l));
		rawMaterialsList.add(new RawMaterials(2, "iron", 50l));
		
		when(rawMaterialsRepository.findAll()).thenReturn(rawMaterialsList);
		assertEquals(rawMaterialsList.size(), rawMaterialService.getAllRawMaterials().size());
	}
	
	@Test
	public void testGetAllRawMaterials_ComparingContents() {
		List<RawMaterials> rawMaterialsList=new ArrayList<RawMaterials>();
		rawMaterialsList.add(new RawMaterials(1, "wood", 100l));
		rawMaterialsList.add(new RawMaterials(2, "iron", 50l));
		
		when(rawMaterialsRepository.findAll()).thenReturn(rawMaterialsList);
		assertEquals(rawMaterialsList.get(0).getName(), rawMaterialService.getAllRawMaterials().get(0).getName());
	}
	
	@Test
	public void testAddRawMaterials() {
		RawMaterials rawMaterials=new RawMaterials(1, "wood", 150);
		rawMaterialService.addRawMaterials(rawMaterials);

		verify(rawMaterialsRepository).save(rawMaterials);
	}
}
