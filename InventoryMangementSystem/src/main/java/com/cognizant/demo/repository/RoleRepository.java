package com.cognizant.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.demo.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRoleId(int id);
}
