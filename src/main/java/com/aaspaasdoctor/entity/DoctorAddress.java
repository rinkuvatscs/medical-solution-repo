package com.aaspaasdoctor.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "doctor_address")
public class DoctorAddress {

	
	@Id
	@Column(name = "doc_address_id")
	private Integer docAddressId ;
	
	@Column(name = "d_id")
	private Integer dId ;
	
	private String timing ;
	private String city;
	private String state ;
	private BigInteger pin ;
	private String landmark ;
	private double latitude ;
	private double longitude ;
	
	@Column(name = "created_date")
	private Date createDate ;
	
	@Column(name = "updated_date")
	private Date updatedDate ;

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
	public BigInteger getPin() {
		return pin;
	}
	public void setPin(BigInteger pin) {
		this.pin = pin;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
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
	public Integer getDocAddressId() {
		return docAddressId;
	}
	public void setDocAddressId(Integer docAddressId) {
		this.docAddressId = docAddressId;
	}
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
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
		return "DoctorAddress [timing=" + timing + ", city=" + city
				+ ", state=" + state + ", pin=" + pin + ", landmark="
				+ landmark + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
		
	
	
}
