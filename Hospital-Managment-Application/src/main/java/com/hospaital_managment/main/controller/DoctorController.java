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
import com.hospaital_managment.main.model.Appointment;
import com.hospaital_managment.main.model.Doctor;
import com.hospaital_managment.main.repository.DoctorRepository;
import com.hospaital_managment.main.service.AppoinmetService;
import com.hospaital_managment.main.service.DocatorService;

/*
 * All doctor operations are performed using this url.
 */
@RestController
@RequestMapping("/Doctor")
public class DoctorController {
	
	@Autowired
	private DocatorService doctorService;
	
	
	@Autowired
	private AppoinmetService appoinmetService;
	
	
	/*
	 * to get doctor details
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable ("id") int id) throws Exception{
		Doctor doctor=this.doctorService.getDoctor(id);
		return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
	}
	
	

	/*
	 * to register new doctor 
	 */
	@PostMapping("/register")
	public ResponseEntity<Doctor> registerDoctor(@RequestBody Doctor doctor){
		Doctor db_doctor=    this.doctorService.findByEmail(doctor.getEmail());
		if(db_doctor!=null) {
			return new ResponseEntity<Doctor>(HttpStatus.BAD_REQUEST);
		}
		Doctor registerDoctor=this.doctorService.registerDoctor(doctor);
		return new ResponseEntity<Doctor>(registerDoctor,HttpStatus.CREATED);
	}
	
	
	/*
	 * to get doctor appointment
	 */
	@PostMapping("/getDoctorAppoinment") 
	
 	ResponseEntity<List<Appointment>> getDoctorAppoinment(@RequestBody Doctor doctor){
		
		List<Appointment> appoinmentList=this.doctorService.getDoctorAppoinment(doctor.getEmail(), doctor.getPassword());
		return new ResponseEntity<List<Appointment>>(appoinmentList,HttpStatus.OK);
			
		}

	
	/*
	 * to get doctor list
	 */
	@GetMapping("/getAll")
	public ResponseEntity<List<Doctor>> doctorList(){
		List<Doctor> doctorList=this.doctorService.doctorList();
		
		return new ResponseEntity<List<Doctor>>(doctorList,HttpStatus.OK);
	}
	
	
	/*
	 * to sign in as doctor 
	 */
	@PostMapping("/signIn")
	public ResponseEntity<Doctor> signIn(@RequestBody Doctor doctor){
		Doctor db_doctor=this.doctorService.signIn(doctor.getEmail(), doctor.getPassword());
		if(db_doctor==null) {
			return new ResponseEntity<Doctor>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Doctor>(db_doctor,HttpStatus.OK);
	}
	
	
	/*
	 * to delete doctor details
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteDoctor(@PathVariable("id") int id) throws Exception {
		this.doctorService.deleteDoctor(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("doctor deleted successfully"),HttpStatus.OK);
	}
	
	
	/*
	 * to update doctor details
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable ("id") int id,@RequestBody Doctor doctor) throws Exception{
		Doctor updateDoctor=this.doctorService.updateDoctor(id, doctor);
		return new  ResponseEntity<Doctor>(updateDoctor,HttpStatus.OK);
		
		
		
			
	
}
}
