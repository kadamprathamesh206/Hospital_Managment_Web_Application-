package com.hospaital_managment.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospaital_managment.main.model.Admin;
import com.hospaital_managment.main.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;

	
	
	/*
	 * to get admin details using id
	 */
	public Admin getAdmin(int id) throws Exception {
		Admin db_admin=this.adminRepo.findById(id).orElseThrow(()->new Exception("Admin not Found"));
		return db_admin;
	}

	/*
	 * to login as admin using email and password
	 */
	public Admin signIn(String email,String password) {
		Admin admin=this.adminRepo.findByEmailAndPassword(email, password);

		return admin;
	}

	/*
	 * to register new admin
	 */
	public Admin  registerAdmin(Admin admin) {
		Admin registerAdmin=	this.adminRepo.save(admin);
		return registerAdmin;
	}

	/*
	 * to view admin list
	 */
	public List<Admin> adminList(){
		List<Admin> db_AdminList=this.adminRepo.findAll();
		return db_AdminList;
	}


	/*
	 * to delete admin using id
	 */
	public void deletAdmin(int id) throws Exception {
		Admin db_admin=this.adminRepo.findById(id).orElseThrow(()->new Exception("Admin not Found"));

		this.adminRepo.delete(db_admin);

	}

	/*
	 * to apdate the admin email or name
	 */
	public Admin updateAdmin(int id,Admin admin) throws Exception {
		Admin db_admin=this.adminRepo.findById(id).orElseThrow(()->new Exception("Admin not Found"));
		db_admin.setEmail(admin.getEmail());
		db_admin.setName(admin.getName());
		db_admin.setPassword(admin.getPassword());
		Admin updated_admin=this.adminRepo.save(db_admin);
		return updated_admin;

	}

	/*
	 * to find admin using email
	 */
	public Admin findByEmail(String email) {

		Admin admin=	this.adminRepo.findByEmail(email);
		return admin;

	}


}
