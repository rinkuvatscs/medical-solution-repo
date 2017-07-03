package com.aaspaasdoctor.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Appointment;
import com.aaspaasdoctor.service.AppointmentServiceImpl;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	AppointmentServiceImpl appointmentServiceImpl;

	@RequestMapping(method = RequestMethod.GET, value = "/appointment/{appointmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Appointment findAppointmentByAppointmentId(
			@PathVariable Integer appointmentId) {
		return appointmentServiceImpl.findByAppointmentId(appointmentId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/appointment/{pId}/patient", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "view appointment", notes = "view appointment")
	public List<Appointment> viewAppointmentByPatient(@PathVariable Integer pId) {

		return appointmentServiceImpl.findByPatientId(pId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/appointment/{dId}/doctor", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "view appointment", notes = "view appointment")
	public List<Appointment> viewAppointmentByDoctor(@PathVariable Integer dId) {

		return appointmentServiceImpl.findByDoctorId(dId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/appointment/cancel/{appointmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Appointment cancelAppointment(@PathVariable Integer appointmentId) {

		return appointmentServiceImpl.cancelAppointment(appointmentId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/appointment/recover/{appointmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Appointment recoverAppointment(@PathVariable Integer appointmentId) {

		return appointmentServiceImpl.changeStatusToActive(appointmentId);
	}

}
