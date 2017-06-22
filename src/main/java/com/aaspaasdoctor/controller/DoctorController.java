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

import com.aaspaasdoctor.entity.Doctor;
import com.aaspaasdoctor.response.DoctorResponse;
import com.aaspaasdoctor.service.DoctorServiceImpl;

@RestController
@RequestMapping("/api/doctor")
@Api(basePath = "/doctor", value = "doctor", description = "Operations with Landlords", produces = "application/json")
public class DoctorController {

	@Autowired
	DoctorServiceImpl doctorServiceImpl;

	@RequestMapping("/")
	public List<Doctor> getAllDoctors() {
		return doctorServiceImpl.findAllDoctors();
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/delete/{id}/id")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "delete doctor", notes = "delete doctor")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public DoctorResponse deleteDoctorById(@PathVariable Integer id) {

		return new DoctorResponse(doctorServiceImpl.deleteDoctorById(id));
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/delete/{aadhaar}/aadhaar")
	@ResponseBody
	public DoctorResponse deleteDoctorByAdharNumber(@PathVariable String aadhaar) {

		return new DoctorResponse(
				doctorServiceImpl.deleteDoctorByAadhaar(aadhaar));
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/delete/{mobile}/mobile")
	@ResponseBody
	public DoctorResponse deleteDoctorByMobileNumber(@PathVariable String mobile) {

		return new DoctorResponse(
				doctorServiceImpl.deleteDoctorByMobile(mobile));
	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/delete")
	@ResponseBody
	public DoctorResponse deleteDoctor(@RequestBody Doctor doctor) {

		return new DoctorResponse(doctorServiceImpl.deleteDoctor(doctor));
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{id}/id")
	@ResponseBody
	public Doctor getDoctorById(@PathVariable Integer id) {

		return doctorServiceImpl.findDoctorById(id);

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{aadhaar}/aadhaar")
	@ResponseBody
	public Doctor getDoctorByAdharNumber(@PathVariable String aadhaar) {

		return doctorServiceImpl.findDoctorByAadhaar(aadhaar);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{email:.+}/email")
	@ResponseBody
	public Doctor getDoctorByEmail(@PathVariable String email) {

		return doctorServiceImpl.findDoctorByEmail(email);

	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{mobile}/mobile")
	@ResponseBody
	public Doctor getDoctorByMobileNumber(@PathVariable String mobile) {

		return doctorServiceImpl.findDoctorByMobile(mobile);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{name}/name")
	@ResponseBody
	public List<Doctor> getDoctorByName(@PathVariable String name) {

		return doctorServiceImpl.findDoctorByName(name);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{expertisted}/expertisted")
	@ResponseBody
	public List<Doctor> getDoctorByExpertisted(@PathVariable String expertisted) {

		return doctorServiceImpl.findDoctorByExpertise(expertisted);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{fee}/fee")
	@ResponseBody
	public List<Doctor> getDoctorByConsultingFee(@PathVariable Integer fee) {

		return doctorServiceImpl.findDoctorByFee(fee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Doctor updateDoctorRepo(@RequestBody Doctor doctor) {

		return doctorServiceImpl.updateDoctorRepo(doctor);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/signup")
	@ResponseBody
	public Doctor doctorSignUp(@RequestBody Doctor doctor) {

		return doctorServiceImpl.doctorSignUp(doctor);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{days}/recentdoctors")
	@ResponseBody
	public List<Doctor> getRecentDoctors(@PathVariable Integer days) {
		return doctorServiceImpl.getRecentDoctors(days);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/forgot/{mobile}")
	@ResponseBody
	public String forgotPassword(@PathVariable String mobile) {

		return doctorServiceImpl.forgotPassword(mobile);

	}
}
