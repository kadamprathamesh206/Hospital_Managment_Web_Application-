package com.hospaital_managment.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospaital_managment.main.model.Appointment;
import com.hospaital_managment.main.model.Patient;
import com.hospaital_managment.main.repository.AppoinmentRepository;
import com.hospaital_managment.main.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private  PatientRepository patientRepo;
	
	
	@Autowired
	private AppoinmentRepository appoinmentRepository;
	
	
	/*
	 * to get patient details 
	 */
	public Patient getPatient(int id) throws Exception {
		Patient db_patient=	this.patientRepo.findById(id).orElseThrow(()->new Exception("No patient found"));
		return db_patient;
	}
	
	
	
	/*
	 * to register patient
	 */
	public Patient savUser(Patient patient) {
		
	Patient registerUser=this.patientRepo.save(patient);
	
	return registerUser;
	
		
		
	}
	
	
	
	/*
	 * to login as patient 
	 */
	public Patient signIn(String email,String password ) {
		Patient user= this.patientRepo.findByEmailAndPassword(email, password);
				
				return user;
	}
	
	
	
	/*
	 * to get patient list
	 */
	public ArrayList<Patient> allPatient(){
	ArrayList<Patient> patientList=	 (ArrayList<Patient>) this.patientRepo.findAll();
	
	return patientList;
	}
	
	
	
	/*
	 * to delete patient details
	 */
	public void deletpatient(int id) throws Exception {
	Patient db_patient=	this.patientRepo.findById(id).orElseThrow(()->new Exception("No patient found"));
		this.patientRepo.delete(db_patient);
	}
	
	
	
	/*
	 * to update patient details 
	 */
	public Patient updatePatient(int id,Patient patient) throws Exception {
		Patient db_patient=	this.patientRepo.findById(id).orElseThrow(()->new Exception("No patient found"));
		db_patient.setEmail(patient.getEmail());
		db_patient.setName(patient.getName());
		db_patient.setPassword(patient.getPassword());
		db_patient.setPhone_no(patient.getPhone_no());
		
		Patient updated_patient=this.patientRepo.save(db_patient);
		
		return updated_patient;
	}
	
	
	
	/*
	 * to get appointment details of patient
	 */
	public List<Appointment> getAppoinmentOfPatient(String email){
		
	List<Appointment> appoinmentList=	this.appoinmentRepository.findByEmail(email);
	
	return appoinmentList;	
	}
	
	
	/*
	 * find patient using email
	 */
	public Patient findByEmail(String email) {
		Patient db_patient=   this.patientRepo.findByEmail(email);
		return db_patient;
	}

}
