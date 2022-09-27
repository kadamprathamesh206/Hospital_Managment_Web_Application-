package com.hospaital_managment.main.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospaital_managment.main.model.Appointment;
import com.hospaital_managment.main.repository.AppoinmentRepository;

import antlr.collections.List;

@Service
public class AppoinmetService {
	@Autowired
	private AppoinmentRepository appoinmentRepo;

	/*
	 * to get appointment of particular id
	 */
	public Appointment getAppointment(int id) throws Exception {

		Appointment appoinment = this.appoinmentRepo.findById(id)
				.orElseThrow(() -> new Exception("Appoinment not found"));
		
		return appoinment;

	}

	/*
	 * to fix that appointment and save it.
	 */
	public Appointment saveAppoinment(Appointment appoinment) {
		Appointment saveAppoinment = this.appoinmentRepo.save(appoinment);
		
		return saveAppoinment;
	}

	/*
	 * to cancel the booked appointment and delete it.
	 */
	public void cancelAppointment(int id) throws Exception {
		Appointment appoinment = this.appoinmentRepo.findById(id)
				.orElseThrow(() -> new Exception("Appoinment not found"));
		
		this.appoinmentRepo.delete(appoinment);

	}

	/*
	 * to view all appointment list
	 */
	public ArrayList<Appointment> allAppoinment() {

		ArrayList<Appointment> allAppoinment = (ArrayList<Appointment>) this.appoinmentRepo.findAll();
		return allAppoinment;

	}

	/*
	 * to update the appointment details like age,contact,name,day etc
	 */
	public Appointment updateAppoinment(int id, Appointment appoinment) throws Exception {

		Appointment db_appoinment = this.appoinmentRepo.findById(id)
				.orElseThrow(() -> new Exception("Appoinment not found"));
		db_appoinment.setAge(appoinment.getAge());
		db_appoinment.setContact(appoinment.getContact());
		db_appoinment.setDay(appoinment.getDay());
		db_appoinment.setDescription(appoinment.getDescription());
		db_appoinment.setEmail(appoinment.getEmail());
		db_appoinment.setName(appoinment.getName());
		db_appoinment.setDoctor_id(appoinment.getDoctor_id());
		db_appoinment.setSpeciality(appoinment.getSpeciality());

		Appointment updatedAppointment = this.appoinmentRepo.save(db_appoinment);
		return updatedAppointment;

	}
}
