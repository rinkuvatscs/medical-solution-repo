package com.aaspaasdoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Doctor;
import com.aaspaasdoctor.service.DoctorServiceImpl;


@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

	@Autowired
	DoctorServiceImpl doctorServiceImpl ;
	
	
	@RequestMapping("/")
	public List<Doctor> getAllDoctors(){
		return doctorServiceImpl.findAllDoctors();
	}
	
}
