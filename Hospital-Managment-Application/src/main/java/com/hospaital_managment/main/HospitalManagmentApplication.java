package com.hospaital_managment.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@CrossOrigin(origins = "http://localhost:4200")
public class HospitalManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagmentApplication.class, args);
	}

}
