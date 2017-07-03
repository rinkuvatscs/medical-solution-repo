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


@Table(name = "doctor")
@Entity
public class Doctor  {

	@Id
	@Column(name = "d_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer dId;

	private String name;
	private String mobile;
	@Column(name = "aadhaar_number")
	private String aadhaar;
	private String clinic;

	@Column(name = "home_address")
	private String homeAddress;
	@Column(name = "highest_degree")
	private String highestDegree;

	private String expertise;

	@Column(name = "self_desc")
	private String selfDescription;

	@Column(name = "gov")
	private Integer isGoverment;

	private Integer fee;
	@Column(name = "free_day")
	private Integer freeDay;

	private String email;
	private String gender;
	private String state;

	@Column(name = "dob")
	private Date dateOfBrith;

	private String timing;

	@Column(name = "tand_c_accepted")
	private Integer tandCAccepted;

	private Integer verified;

	@Column(name = "profile_pic_path")
	private String profilePicPath;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", columnDefinition = "DATETIME")
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", columnDefinition = "DATETIME")
	private Date updatedDate;

	@OneToOne(cascade =  CascadeType.ALL )
	@JoinColumn(name = "d_id")
	private DoctorAddress doctorAddress;

	@Column(name = "description")
	private String desc;

	@Transient
	private String password;

	public String getPassword() {
		return password;
	}

	public DoctorAddress getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(DoctorAddress doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
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

	public String getClinic() {
		return clinic;
	}

	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getSelfDescription() {
		return selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

	public Integer getIsGoverment() {
		return isGoverment;
	}

	public void setIsGoverment(Integer isGoverment) {
		this.isGoverment = isGoverment;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Integer getFreeDay() {
		return freeDay;
	}

	public void setFreeDay(Integer freeDay) {
		this.freeDay = freeDay;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(Date dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public Integer getTandCAccepted() {
		return tandCAccepted;
	}

	public void setTandCAccepted(Integer tandCAccepted) {
		this.tandCAccepted = tandCAccepted;
	}

	public Integer getVerified() {
		return verified;
	}

	public void setVerified(Integer verified) {
		this.verified = verified;
	}

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
