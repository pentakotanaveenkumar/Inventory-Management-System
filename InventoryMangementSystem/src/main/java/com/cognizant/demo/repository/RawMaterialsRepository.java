package com.cognizant.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.demo.entity.RawMaterials;

@Repository
public interface RawMaterialsRepository extends JpaRepository<RawMaterials, Integer>{

	RawMaterials findByName(String name);
}
