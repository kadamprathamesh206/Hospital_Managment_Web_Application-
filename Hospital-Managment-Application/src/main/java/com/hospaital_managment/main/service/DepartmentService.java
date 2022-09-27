package com.hospaital_managment.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospaital_managment.main.model.Department;
import com.hospaital_managment.main.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	/*
	 * to get department details using id
	 */
	public Department getDepartment(int id) throws Exception {
		Department department = this.departmentRepository.findById(id)
				.orElseThrow(() -> new Exception("department not found"));

		return department;
	}

	/*
	 * to add new department
	 */
	public Department addDepartment(Department department) {

		Department db_department = this.departmentRepository.save(department);

		return db_department;
	}

	/*
	 * to get all department details in list format
	 */
	public List<Department> departmentList() {

		List<Department> departmentList = this.departmentRepository.findAll();

		return departmentList;
	}

	/*
	 * to delete department details
	 */
	public void deletDepartment(int id) throws Exception {
		Department department = this.departmentRepository.findById(id)
				.orElseThrow(() -> new Exception("department not found"));

		this.departmentRepository.delete(department);
	}

	/*
	 * to update department details
	 */
	public Department updateDepartment(int id, Department department) throws Exception {
		Department db_department = this.departmentRepository.findById(id)
				.orElseThrow(() -> new Exception("department not found"));
		db_department.setDep_name(department.getDep_name());
		db_department.setDesc(department.getDesc());
		Department updatedDepartment = this.departmentRepository.save(db_department);

		return updatedDepartment;
	}

}
