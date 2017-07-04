package com.aaspaasdoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Calendar;
import com.aaspaasdoctor.service.CalendarServiceImpl;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

	@Autowired
	private CalendarServiceImpl calendarServiceImpl;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/calendar/add")
	@ResponseBody
	public Calendar addCalendarEvent(@RequestBody Calendar calendar) {

		return calendarServiceImpl.addCalendarEvent(calendar);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/calendar/update")
	@ResponseBody
	public Calendar updateCalendar(@RequestBody Calendar calendar) {

		return calendarServiceImpl.updateCalendar(calendar);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/calendar/{pId}/patient")
	@ResponseBody
	public List<Calendar> getCalendarEventForPatient(@PathVariable Integer pId) {

		return calendarServiceImpl.getCalendarEventByPatientId(pId);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/calendar/{dId}/doctor")
	@ResponseBody
	public List<Calendar> getCalendarEventForDoctor(@PathVariable Integer dId) {

		return calendarServiceImpl.getCalendarByDoctorId(dId);
	}

	// Delete Calendar for both
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/calendar/{calendarId}/delete")
	@ResponseBody
	public Calendar deleteCalendar(@RequestParam Integer calendarId) {

		return calendarServiceImpl.deleteCalendar(calendarId);
	}
}
