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

@Table(name = "appointment")
@Entity
public class Appointment {

	@Id
	@Column(name = "appointment_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appointmentId;

	@Column(name = "d_id")
	private Integer dId;

	@Column(name = "p_id")
	private Integer pId;

	@Column(name = "appointment_Date")
	private Date appointmentDate;

	@Column(name = "appointment_Desc")
	private String appointmentDesc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_Date", columnDefinition = "DATETIME")
	private Date createdDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "p_id")
	private Patient patient;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "d_id")
	private Doctor doctor;

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getAppointmentDesc() {
		return appointmentDesc;
	}

	public void setAppointmentDesc(String appointmentDesc) {
		this.appointmentDesc = appointmentDesc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
