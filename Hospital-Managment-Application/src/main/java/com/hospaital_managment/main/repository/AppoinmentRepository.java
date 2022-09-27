package com.hospaital_managment.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospaital_managment.main.model.Appointment;


@Repository
public interface AppoinmentRepository extends JpaRepository<Appointment, Integer> {

	/*
	 * find all appointment details using doctors id
	 */
	public List<Appointment> findByDoctorid(int doctorid);
	/*
	 * find all appointment details using email id
	 */
	public List<Appointment> findByEmail(String email);
}
