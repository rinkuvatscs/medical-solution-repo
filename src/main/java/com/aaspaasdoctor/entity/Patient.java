package com.aaspaasdoctor.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Table(name = "patient")
@Entity
public class Patient {

	@Id
	@Column(name = "p_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;

	private String name;
	private String mobile;

	@Column(name = "aadhaar_number")
	private String aadhaar;

	private String email;
	private String gender;
	private String allergies;

	@Column(name = "dob")
	private Date dateOfBrith;
	
	@Transient
	private String password;
	
	private String profilePicPath;
	@Column(name = "tand_c_accepted")
	private Integer tandCAccepted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", columnDefinition = "DATETIME")
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", columnDefinition = "DATETIME")
	private Date updatedDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "p_id")
	private PatientAddress patientAddress;
	
	@OneToOne(mappedBy="patient")
	private Appointment appointment;

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}

	public Date getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(Date dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}

	public Integer getTandCAccepted() {
		return tandCAccepted;
	}

	public void setTandCAccepted(Integer tandCAccepted) {
		this.tandCAccepted = tandCAccepted;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public PatientAddress getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(PatientAddress patientAddress) {
		this.patientAddress = patientAddress;
	}

	@Override
	public String toString() {
		return "Patient [pId=" + pId + ", name=" + name + ", mobile=" + mobile
				+ ", aadhaar=" + aadhaar + ", email=" + email + ", gender="
				+ gender + ", allergies=" + allergies + ", dateOfBrith="
				+ dateOfBrith + ", password=" + password + ", profilePicPath="
				+ profilePicPath + ", tandCAccepted=" + tandCAccepted
				+ ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", patientAddress=" + patientAddress + "]";
	}

}
