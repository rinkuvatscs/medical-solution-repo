package com.aaspaasdoctor.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Patient;
import com.aaspaasdoctor.service.PatientServiceImpl;

@RestController
@RequestMapping("/api/patient")
@Api(basePath = "/patient", value = "patient", description = "Operations with Landlords", produces = "application/json")
public class PatientController {

	@Autowired
	private PatientServiceImpl patientServiceImpl;

	
	@RequestMapping("/")
	public List<Patient> getAllPatients() {
		return patientServiceImpl.findAllPatients();
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "add new patient", notes = "add new patient")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public Patient addPatient(@RequestBody Patient patient) {
		return patientServiceImpl.addPatient(patient);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{aadhaarNumber}/aadhaar")
	@ResponseBody
	public Patient getPatientByAdharNumber(@PathVariable String aadhaarNumber) {
		return patientServiceImpl.getPatientByAadhaar(aadhaarNumber);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{mobile}/mobile")
	@ResponseBody
	public Patient getPatientByMobile(@PathVariable String mobile) {
		return patientServiceImpl.getPatientByMobile(mobile);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{patientId}/id")
	@ResponseBody
	public Patient getPatientByPatientId(@PathVariable Integer patientId) {
		return patientServiceImpl.getPatientById(patientId);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{email:.+}/email")
	@ResponseBody
	public Patient getPatientByEmail(@PathVariable String email) {
		return patientServiceImpl.getPatientByEmail(email);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{name}/name")
	@ResponseBody
	public List<Patient> getPatientByName(@PathVariable String name) {
		return patientServiceImpl.getPatientByName(name);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "update patient", notes = "update patient")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public Patient updatePatient(@RequestBody Patient patient) {

		return patientServiceImpl.updatePatient(patient);
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "/signUp")
	public Patient patientSignUp(@RequestBody Patient patient) {
		return patientServiceImpl.patientSignUp(patient);
	}
}
