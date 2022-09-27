package com.hospaital_managment.main.model;
import javax.validation.constraints.Email;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Email
	private String email;
	private Long contact;
	private int age;
	private String day;
	private String speciality;
	private String description;
	private int doctorid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDoctor_id() {
		return doctorid;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctorid = doctor_id;
	}

	public Appointment(int id, String name, String email, Long contact, int age, String day, String speciality,
			String description,int doctor_id) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.age = age;
		this.day = day;
		this.speciality = speciality;
		this.description = description;
		this.doctorid=doctor_id;
	}
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", age=" + age
				+ ", day=" + day + ", speciality=" + speciality + ", description=" + description + "]";
	}


}
