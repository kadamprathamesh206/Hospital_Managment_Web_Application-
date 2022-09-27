package com.hospaital_managment.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hospaital_managment.main.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
	/*
	 * to find patient using email and password
	 */
	Patient findByEmailAndPassword(String email,String password);
	
	 public Patient  findByEmail(String email);
	 
	 @Query("select a from Patient a where a.email= :n and a.password= :w" )
		public Patient findByemailAndpassword(@Param("n") String email,@Param("w") String password);

}
