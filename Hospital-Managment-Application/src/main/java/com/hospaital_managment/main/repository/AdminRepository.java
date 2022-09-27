package com.hospaital_managment.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospaital_managment.main.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	/*
	 * to find admin from DB using email and password
	 */
	public Admin findByEmailAndPassword(String email,String password);
	/*
	 * to find admin from DB using email.
	 */
	public Admin findByEmail(String email);

}
