package com.aaspaasdoctor.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "patient_address")
public class PatientAddress {

	@Id
	@Column(name = "patient_address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientAddressId;

	@Column(name = "p_id")
	private Integer pId;

	private String timing;
	private String city;
	private String state;
	private BigInteger pin;
	private double latitude;
	private double longitude;
	@Column(name = "home_address")
	private String homeAddress;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "patient_add_created_date", columnDefinition = "DATETIME")
	private Date patientAddressCreateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "patient_add_updated_date", columnDefinition = "DATETIME")
	private Date patientAddressUpdatedDate;

	public Integer getPatientAddressId() {
		return patientAddressId;
	}

	public void setPatientAddressId(Integer patientAddressId) {
		this.patientAddressId = patientAddressId;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigInteger getPin() {
		return pin;
	}

	public void setPin(BigInteger pin) {
		this.pin = pin;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Date getPatientAddressCreateDate() {
		return patientAddressCreateDate;
	}

	public void setPatientAddressCreateDate(Date patientAddressCreateDate) {
		this.patientAddressCreateDate = patientAddressCreateDate;
	}

	public Date getPatientAddressUpdatedDate() {
		return patientAddressUpdatedDate;
	}

	public void setPatientAddressUpdatedDate(Date patientAddressUpdatedDate) {
		this.patientAddressUpdatedDate = patientAddressUpdatedDate;
	}

}
