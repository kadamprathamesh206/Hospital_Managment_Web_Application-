package com.hospaital_managment.main.controller;

import java.util.ArrayList;

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
import com.hospaital_managment.main.model.Appointment;
import com.hospaital_managment.main.service.AppoinmetService;

/*
 * All appointment operations are performed using this url.
 */
@RestController
@RequestMapping("/appoinment")
public class AppointmentController {

	@Autowired
	private AppoinmetService appoinmentService;

	/*
	 * to get appointment details
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Appointment> getAppoinment(@PathVariable("id") int id) throws Exception {
		Appointment appointmnt = this.appoinmentService.getAppointment(id);
		
		return new ResponseEntity<Appointment>(appointmnt, HttpStatus.OK);
	}

	/*
	 * to create the appointment
	 */
	@PostMapping("/createappoinment")
	public ResponseEntity<Appointment> saveAppoinment(@RequestBody Appointment appoinment) {

		Appointment saveAppoinment = appoinmentService.saveAppoinment(appoinment);

		return new ResponseEntity<Appointment>(saveAppoinment, HttpStatus.CREATED);

	}

	/*
	 * to delete appointment details of particular id
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> cancleAppoinmet(@PathVariable("id") int id) throws Exception {
		this.appoinmentService.cancelAppointment(id);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("cancel appoinment successfully"), HttpStatus.OK);

	}

	/*
	 * to get appointments details in list format
	 */
	@GetMapping("/appointemtlist")

	public ResponseEntity<ArrayList<Appointment>> allAppoinments() {

		ArrayList<Appointment> allAppoinment = this.appoinmentService.allAppoinment();

		return new ResponseEntity<ArrayList<Appointment>>(allAppoinment, HttpStatus.OK);
	}

	/*
	 * to update appointment details
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Appointment> updateAppoinment(@PathVariable("id") int id,
			@RequestBody Appointment appointment) throws Exception {
		Appointment appoinment = this.appoinmentService.updateAppoinment(id, appointment);
		
		return new ResponseEntity<Appointment>(appoinment, HttpStatus.OK);

	}
}
