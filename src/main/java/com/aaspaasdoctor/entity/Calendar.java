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
@Table(name = "calendar")
public class Calendar {

	@Id
	@Column(name = "calendar_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer calendarId;

	@Column(name = "calendar_event_id")
	private Integer calendarEventId;

	@Column(name = "calendar_title")
	private String calendarTitle;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", columnDefinition = "DATETIME")
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", columnDefinition = "DATETIME")
	private Date endDate;

	@Column(name = "p_id")
	private Integer pId;

	@Column(name = "d_id")
	private Integer dId;

	public Integer getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(Integer calendarId) {
		this.calendarId = calendarId;
	}

	public Integer getCalendarEventId() {
		return calendarEventId;
	}

	public void setCalendarEventId(Integer calendarEventId) {
		this.calendarEventId = calendarEventId;
	}

	public String getCalendarTitle() {
		return calendarTitle;
	}

	public void setCalendarTitle(String calendarTitle) {
		this.calendarTitle = calendarTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

}
