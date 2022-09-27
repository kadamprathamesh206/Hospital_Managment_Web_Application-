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
import org.springframework.web.bind.annotation.RestController;

import com.hospaital_managment.main.config.ApiResponse;
import com.hospaital_managment.main.model.Department;
import com.hospaital_managment.main.repository.DepartmentRepository;
import com.hospaital_managment.main.service.DepartmentService;

/*
 *  All appointment operations are performed using this url.
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	/*
	 * to get department details
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable("id") int id) throws Exception {
		Department department = this.departmentService.getDepartment(id);

		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}

	/*
	 * to create new department
	 */
	@PostMapping("/createdepartment")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {

		Department db_department = this.departmentService.addDepartment(department);

		return new ResponseEntity<Department>(db_department, HttpStatus.CREATED);

	}

	/*
	 * to get all department details
	 */
	@GetMapping("/getAllDepartment")
	public ResponseEntity<List<Department>> departmentList() {
		List<Department> departmentList = this.departmentService.departmentList();

		return new ResponseEntity<List<Department>>(departmentList, HttpStatus.OK);
	}

	/*
	 * to delete department details
	 */
	@DeleteMapping("/delete/{id}")

	public ResponseEntity<ApiResponse> deleteDepartment(@PathVariable("id") int id) throws Exception {
		this.departmentService.deletDepartment(id);

		return new ResponseEntity<ApiResponse>(new ApiResponse("user delated successfully"), HttpStatus.OK);
	}

	/*
	 * to update department details
	 */
	@PutMapping("/put/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") int id, @RequestBody Department department)
			throws Exception {
		Department updatedDepartment = this.departmentService.updateDepartment(id, department);

		return new ResponseEntity<Department>(updatedDepartment, HttpStatus.OK);
	}

}
