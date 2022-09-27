package com.hospaital_managment.main.model;
import javax.validation.constraints.Email;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String phone_no;
	@Email
	private String email;
	private String desc;
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
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Feedback(int id, String name, String phone_no, String email, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.phone_no = phone_no;
		this.email = email;
		this.desc = desc;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

}
