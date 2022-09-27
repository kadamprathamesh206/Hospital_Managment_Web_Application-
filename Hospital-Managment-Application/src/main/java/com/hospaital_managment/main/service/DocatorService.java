package com.hospaital_managment.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospaital_managment.main.model.Appointment;
import com.hospaital_managment.main.model.Doctor;
import com.hospaital_managment.main.repository.AppoinmentRepository;
import com.hospaital_managment.main.repository.DoctorRepository;

@Service
public class DocatorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private AppoinmentRepository appoinmentRepository;
	
	
	/*
	 * to get doctor details
	 */
	public Doctor getDoctor(int id) throws Exception {
		Doctor doctor=	this.doctorRepository.findById(id).orElseThrow(()->new Exception("No doctor present"));
		return doctor;
	}
	/*
	 * to login as doctor 
	 */
	public Doctor signIn(String email ,String password ) {
	Doctor doctor=	this.doctorRepository.findByEmailAndPassword(email, password);
	
	return doctor;
	}

	/*
	 * to add new doctor details
	 */
	public  Doctor registerDoctor(Doctor doctor) {
	Doctor registerDoctor= 	this.doctorRepository.save(doctor);
	return registerDoctor;
	}
	
	/*
	 * to get doctor list
	 */
	public ArrayList<Doctor> doctorList(){
	ArrayList<Doctor> doctorList=	(ArrayList<Doctor>) this.doctorRepository.findAll();
	return doctorList;
		
	}
	
	/*
	 * to delete doctor details
	 */
	public void deleteDoctor(int id) throws Exception {
	Doctor doctor=	this.doctorRepository.findById(id).orElseThrow(()->new Exception("No doctor present"));
	
	this.doctorRepository.delete(doctor);
	}
	
	/*
	 * to update doctor details
	 */
	public Doctor updateDoctor(int id,Doctor doctor) throws Exception {
		Doctor db_doctor=	this.doctorRepository.findById(id).orElseThrow(()->new Exception("No doctor present"));
		db_doctor.setDesc(doctor.getDesc());
		db_doctor.setEmail(doctor.getEmail());
		db_doctor.setFees(doctor.getFees());
		db_doctor.setName(doctor.getName());
		db_doctor.setPassword(doctor.getPassword());
		Doctor updatedDoctor=this.doctorRepository.save(db_doctor);
		return updatedDoctor;
	}
	
	/*
	 * to get doctor appointment
	 */
	public List<Appointment> getDoctorAppoinment(String email,String password) {
		
	Doctor doctor=	this.doctorRepository.findByEmailAndPassword(email, password);
	
	    List<Appointment> doctor_appoinment=  this.appoinmentRepository.findByDoctorid(doctor.getId());
	    
	    
	    return doctor_appoinment;
	
		
	}
	public Doctor findByEmail(String email) {
		Doctor db_doctor= this.doctorRepository.findByEmail(email);
		return db_doctor;
	}
}
