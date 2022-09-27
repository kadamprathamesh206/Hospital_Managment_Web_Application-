package com.hospaital_managment.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
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
import com.hospaital_managment.main.model.Patient;
import com.hospaital_managment.main.repository.PatientRepository;
import com.hospaital_managment.main.service.PatientService;

/*
 * All patient operations are performed using this url.
 */
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientservice;

	/*
	 * to get patient details
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable("id") int id) throws Exception {
		Patient patient = this.patientservice.getPatient(id);

		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

	/*
	 * to register new patient
	 */
	@PostMapping("/register")
	public ResponseEntity<Patient> saveUser(@RequestBody Patient patient) {
		Patient db_patient = this.patientservice.findByEmail(patient.getEmail());
		if (db_patient != null) {
			return new ResponseEntity<Patient>(HttpStatus.BAD_REQUEST);
		}

		Patient registerUser = this.patientservice.savUser(patient);

		return new ResponseEntity<Patient>(registerUser, HttpStatus.CREATED);

	}

	/*
	 * to login as patient
	 */
	@PostMapping("/signin")
	public ResponseEntity<Patient> signIn(@RequestBody Patient newpatient) {

		Patient patient = this.patientservice.signIn(newpatient.getEmail(), newpatient.getPassword());
		if (patient == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		}
	}

	/*
	 * to get patient list
	 */
	@GetMapping("/allpatient")
	public ResponseEntity<ArrayList<Patient>> allPatient() {
		ArrayList<Patient> patientList = this.patientservice.allPatient();

		return new ResponseEntity<ArrayList<Patient>>(patientList, HttpStatus.OK);

	}

	/*
	 * to delete patient details
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletepatient(@PathVariable int id) throws Exception {
		this.patientservice.deletpatient(id);

		return new ResponseEntity<ApiResponse>(new ApiResponse("patient deleted succesfuly"), HttpStatus.OK);

	}

	/*
	 * to update patient details
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatepatient(@PathVariable int id, @RequestBody Patient patient) throws Exception {
		Patient update_patient = this.patientservice.updatePatient(id, patient);

		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

	/*
	 * to get appointment details for patient
	 */
	@PostMapping("/getappoinmentOfPatient")
	public ResponseEntity<List<Appointment>> getappoinmentOfPatient(@RequestBody Patient patient) {
		List<Appointment> appoinmentList = this.patientservice.getAppoinmentOfPatient(patient.getEmail());

		return new ResponseEntity<List<Appointment>>(appoinmentList, HttpStatus.OK);

	}
}
