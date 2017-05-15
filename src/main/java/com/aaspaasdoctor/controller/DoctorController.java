package com.aaspaasdoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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

	// ==========

	// NEED TO IMGRATE below services
	/*
	 * @RequestMapping(method = RequestMethod.DELETE, consumes =
	 * MediaType.APPLICATION_JSON_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE, value = "/delete")
	 * 
	 * @ResponseBody public Response deleteDoctor(@RequestBody Doctor doctor) {
	 * 
	 * return new Response(doctorService.deleteDoctor(doctor)); }
	 * 
	 * 
	 * @RequestMapping(method = RequestMethod.POST, produces =
	 * MediaType.APPLICATION_JSON_VALUE, value = "/get/all")
	 * 
	 * @ResponseBody public List<DoctorResponse> getDoctorByAll(
	 * 
	 * @RequestBody SearchDoctorRequest searchDoctorRequest) {
	 * 
	 * Doctor doctor = new Doctor(); try {
	 * BeanUtils.copyProperties(searchDoctorRequest, doctor); } catch
	 * (BeansException beansException) { throw new
	 * BadRequestException(DOCTOR_BADREQEST_MESSAGE, beansException); } return
	 * doctorMapper.mapDoctors(doctorService.getDoctors(doctor));
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * @RequestMapping(method = RequestMethod.PUT, value = "/", produces =
	 * MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @ResponseStatus(HttpStatus.OK)
	 * 
	 * @ApiOperation(value = "update doctor", notes = "update doctor")
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 400, message = "Fields are with validation errors"),
	 * 
	 * @ApiResponse(code = 201, message = "") }) public Response
	 * updateDoctor(@RequestBody DoctorRequest doctorRequest) {
	 * 
	 * Doctor doctor = new Doctor(); try {
	 * BeanUtils.copyProperties(doctorRequest, doctor); } catch (BeansException
	 * beansException) { throw new BadRequestException(DOCTOR_BADREQEST_MESSAGE,
	 * beansException); } return new
	 * Response(doctorService.updateDoctor(doctor)); }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, value = "/intro") public
	 * String welcome() {
	 * 
	 * return "Welcome to Doctor Management Tool"; }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, produces =
	 * MediaType.APPLICATION_JSON_VALUE, value = "/get/all/expertisation")
	 * 
	 * @ResponseBody public List<String> getAllExpertisations() {
	 * 
	 * return doctorService.getAllExpertized(); }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, produces =
	 * MediaType.APPLICATION_JSON_VALUE, value =
	 * "/add/{expertise}/expertisation")
	 * 
	 * @ResponseBody public Integer addExpertisation(@PathVariable String
	 * expertise) {
	 * 
	 * if (!StringUtils.isEmpty(expertise)) { return
	 * doctorService.addExpertisation(expertise); } else { throw new
	 * BadRequestException("Expertisation can not be blank"); } }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, produces =
	 * MediaType.APPLICATION_JSON_VALUE, value = "/get/{days}/recentdoctors")
	 * 
	 * @ResponseBody public List<DoctorResponse> getRecentDoctors(@PathVariable
	 * Integer days) { if (!StringUtils.isEmpty(days) && days > 0) { return
	 * doctorMapper .mapDoctors(doctorService.getRecentDoctors(days)); } else {
	 * throw new BadRequestException("Doctor ID should not be blank"); } }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, produces =
	 * MediaType.APPLICATION_JSON_VALUE, value =
	 * "/get/all/unapproved/expertisation")
	 * 
	 * @ResponseBody public List<String> getAllUnApprovedExpertisations() {
	 * 
	 * return doctorService.getUnApprovedExpertise(); }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, produces =
	 * MediaType.APPLICATION_JSON_VALUE, value =
	 * "/approve/{expertise}/expertisation")
	 * 
	 * @ResponseBody public String addExpertisation(@PathVariable Integer
	 * expertise) {
	 * 
	 * if (!StringUtils.isEmpty(expertise)) { return
	 * doctorService.approveExpertise(expertise); } else { throw new
	 * BadRequestException("Expertisation can not be blank"); } }
	 * 
	 * @RequestMapping(method = RequestMethod.PUT, produces =
	 * MediaType.APPLICATION_JSON_VALUE, value = "/signup")
	 * 
	 * @ResponseBody public Integer doctorSignUp(@RequestBody Doctor doctor) {
	 * 
	 * if (!StringUtils.isEmpty(doctor) && !doctor.getName().isEmpty() &&
	 * !doctor.getEmail().isEmpty() && !doctor.getMobile().isEmpty() &&
	 * !doctor.getAadhaarNumber().isEmpty() && !doctor.getPassword().isEmpty())
	 * { return doctorService.doctorSignUp(doctor); } else { throw new
	 * BadRequestException( "Doctor SignUp details should not be blank"); } }
	 */

}
