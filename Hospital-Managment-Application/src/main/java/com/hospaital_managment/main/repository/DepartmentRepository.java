package com.hospaital_managment.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospaital_managment.main.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	

}
