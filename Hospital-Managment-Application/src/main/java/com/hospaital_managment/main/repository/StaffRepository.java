package com.hospaital_managment.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospaital_managment.main.model.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
