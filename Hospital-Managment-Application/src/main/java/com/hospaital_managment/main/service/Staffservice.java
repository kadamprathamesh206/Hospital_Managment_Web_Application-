package com.hospaital_managment.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospaital_managment.main.model.Staff;
import com.hospaital_managment.main.repository.StaffRepository;

@Service
public class Staffservice {
	
	@Autowired
	private StaffRepository staffRepository;
	
	
	/*
	 * get list of all working staff
	 */
	public List<Staff> getAllStaff(){
	List<Staff> staffList=	this.staffRepository.findAll();
	return staffList;
		
	}
	

}
