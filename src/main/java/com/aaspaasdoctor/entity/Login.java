package com.aaspaasdoctor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name ="login")
public class Login {

	
	@Id
	@Column(name = "login_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer loginId;
	
	private String mobile ;
	
	private String password ;
	
	private String aadhaar ;
	
	private String email ;
	
	private String type ;
	
	@Column(name = "type_id")
	private Integer typeId ;
	
	@Column(name = "created_date")
	private Date createDate ;
	
	@Column(name = "updated_date")
	private Date updatedDate ;
	
	@Transient
	private PasswordEncoder passwordEncode = new BCryptPasswordEncoder(); 

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = passwordEncode.encode(password);
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", mobile=" + mobile
				+ ", password=" + password + ", aadhaar=" + aadhaar
				+ ", email=" + email + ", type=" + type + ", typeId=" + typeId
				+ ", createDate=" + createDate + ", updatedDate=" + updatedDate
				+ "]";
	}

	
	
}
