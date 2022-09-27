package com.hospaital_managment.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospaital_managment.main.model.Staff;
import com.hospaital_managment.main.service.Staffservice;


/*
 * All appointment operations are performed using this url.
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private Staffservice staffservice;
   
	/*
	 * get list of all working staff
	 */
	@GetMapping("/getStaff")
	public ResponseEntity<List<Staff>> getAllStaff(){

		List<Staff> stafflist=this.staffservice.getAllStaff();
		return new ResponseEntity<List<Staff>>(stafflist,HttpStatus.OK);
	}


}
