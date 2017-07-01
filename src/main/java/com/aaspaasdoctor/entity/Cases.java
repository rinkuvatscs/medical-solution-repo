package com.aaspaasdoctor.entity;

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
@Table(name = "cases")
public class Cases {

	@Id
	@Column(name = "case_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer caseId;

	@Column(name = "p_id")
	private Integer patientId;

	@Column(name = "d_id")
	private Integer doctorId;

	@Column(name = "precaution")
	private String precaution;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", columnDefinition = "DATETIME")
	private Date created_Date;

	@Column(name = "closed")
	private Integer closed;

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getPrecaution() {
		return precaution;
	}

	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	public Date getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public Integer getClosed() {
		return closed;
	}

	public void setClosed(Integer closed) {
		this.closed = closed;
	}

	@Override
	public String toString() {
		return "Cases [caseId=" + caseId + ", patientId=" + patientId + ", doctorId=" + doctorId + ", precaution="
				+ precaution + ", created_Date=" + created_Date + ", closed=" + closed + "]";
	}

}
