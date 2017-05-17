package com.aaspaasdoctor.controller;

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
import com.aaspaasdoctor.entity.Expertise;
import com.aaspaasdoctor.response.DoctorResponse;
import com.aaspaasdoctor.service.DoctorServiceImpl;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

	@Autowired
	DoctorServiceImpl doctorServiceImpl;

	@RequestMapping("/")
	public List<Doctor> getAllDoctors() {
		return doctorServiceImpl.findAllDoctors();
	}

	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/delete/{id}/id")
	@ResponseStatus(HttpStatus.OK)
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

	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/all/expertisation")
	@ResponseBody
	public List<Expertise> getAllExpertisations() {

		return doctorServiceImpl.getAllExpertized();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/add/{expertise}/expertisation")
	@ResponseBody
	public Expertise addExpertisation(@PathVariable String expertise) {

		return doctorServiceImpl.addExpertise(new Expertise(expertise));
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/all/unapproved/expertisation")
	@ResponseBody
	public List<Expertise> getAllUnApprovedExpertisations() {

		return doctorServiceImpl.getUnApprovedExpertise();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/approve/{expertise}/expertisation")
	@ResponseBody
	public Expertise addExpertisation(@PathVariable Integer expertiseId) {

			return doctorServiceImpl.approveExpertise(new Expertise(expertiseId));
	}

	
	
	// Same as old for dynamic
	
	@RequestMapping(method = RequestMethod.PUT, value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	
	public DoctorResponse updateDoctor(@RequestBody Doctor doctor) {
		
		return new DoctorResponse(doctorServiceImpl.updateDoctor(doctor));
	}

}
