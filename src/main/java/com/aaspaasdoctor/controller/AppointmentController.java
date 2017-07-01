package com.aaspaasdoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Appointment;
import com.aaspaasdoctor.service.AppointmentServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentServiceImpl appointmentServiceImpl;

	/*@RequestMapping(method = RequestMethod.POST, value = "/appointment/make", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "make appointment", notes = "make appointment")
	public AppointmentResponse makeAppointment(@RequestBody Appointment makeAppointment) {

		return new AppointmentResponse(appointmentFactory.getAppointmentService().makeAppointment(makeAppointment));
	}*/
	
	@RequestMapping(method = RequestMethod.GET, value = "/appointment/{pId}/patient", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "view appointment", notes = "view appointment")
	public List<Appointment> viewAppointmentByPatient(@PathVariable Integer pId) {
		
		return appointmentServiceImpl.findByPatientAndDoctorAndPId(pId);
	}
}
