package com.aaspaasdoctor.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Contact {

	//INSERT INTO contactUs (contactUsId, name, mobile, email, message) VALUES (0, ?, ?, ?, ?)"
	
	@Id
	@Column(name = "contact_us_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	private String name;
	
	private String mobile;
	
	private String email;
	
	private String message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", mobile=" + mobile
				+ ", email=" + email + ", message=" + message + "]";
	}
	

	
	
	
}
