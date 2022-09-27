package com.hospaital_managment.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospaital_managment.main.config.ApiResponse;
import com.hospaital_managment.main.model.Admin;
import com.hospaital_managment.main.service.AdminService;

/*
 *  All admin operations are performed using this url.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	/*
	 * to get exact admin using admin id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("id") int id) throws Exception {
		Admin admin = this.adminService.getAdmin(id);

		return new ResponseEntity<Admin>(admin, HttpStatus.OK);
	}

	/*
	 * to singin as admin
	 */
	@PostMapping("/signIn")

	public ResponseEntity<Admin> signIn(@RequestBody Admin admin) {
		Admin db_admin = this.adminService.signIn(admin.getEmail(), admin.getPassword());
		if (db_admin == null) {
			return new ResponseEntity<Admin>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Admin>(db_admin, HttpStatus.OK);

	}

	/*
	 * to register new admin
	 */
	@PostMapping("/register")

	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
		Admin db_admin = this.adminService.findByEmail(admin.getEmail());
		if (db_admin != null) {
			return new ResponseEntity<Admin>(HttpStatus.BAD_REQUEST);
		}

		Admin registerAmdin = this.adminService.registerAdmin(admin);
		return new ResponseEntity<Admin>(registerAmdin, HttpStatus.CREATED);
	}

	/*
	 * to get all admin list
	 */
	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<Admin>> adminList() {
		List<Admin> AdminList = this.adminService.adminList();

		return new ResponseEntity<List<Admin>>(AdminList, HttpStatus.OK);

	}

	/*
	 * to delete admin of particular id
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletAdmin(@PathVariable("id") int id) throws Exception {
		this.adminService.deletAdmin(id);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Admin Deletd Successfully"), HttpStatus.OK);
	}

	/*
	 * to update admin of particular id
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") int id, @RequestBody Admin admin) throws Exception {
		Admin updateAdmin = this.adminService.updateAdmin(id, admin);

		return new ResponseEntity<Admin>(updateAdmin, HttpStatus.OK);
	}
}
