package com.aaspaasdoctor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaspaasdoctor.entity.Calendar;
import com.aaspaasdoctor.repository.CalendarRepository;

@Transactional
@Service
public class CalendarServiceImpl {

	@Autowired
	private CalendarRepository calendarRepository;

	public Calendar addCalendarEvent(Calendar calendar) {
		return calendarRepository.save(calendar);
	}

	public List<Calendar> getCalendarEventByPatientId(Integer pId) {
		return calendarRepository.findByPId(pId);
	}

	public List<Calendar> getCalendarByDoctorId(Integer dId) {
		return calendarRepository.findByDId(dId);
	}

	public Calendar updateCalendar(Calendar calendar) {
		if (calendar != null && calendar.getCalendarId() != null) {
			Calendar tempCalendar = calendarRepository.findOne(calendar.getCalendarId());
			if (tempCalendar != null) {
				tempCalendar.setCalendarTitle(calendar.getCalendarTitle());
				tempCalendar.setStartDate(calendar.getStartDate());
				tempCalendar.setEndDate(calendar.getEndDate());
				return calendarRepository.save(tempCalendar);
			}
		}
		return new Calendar();
	}

	public Calendar deleteCalendar(Integer calendarId) {
		Calendar calendar = calendarRepository.findOne(calendarId);
		calendarRepository.delete(calendarId);
		return calendar;
	}

}
