package com.hospaital_managment.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospaital_managment.main.model.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
	/*
	 * get details of doctor using email and password
	 */
	public Doctor findByEmailAndPassword(String email,String password);
    
	
	/*
	 * get details of doctor using email.
	 */
	public Doctor findByEmail(String email);
}
