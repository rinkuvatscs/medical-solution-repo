package com.aaspaasdoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaspaasdoctor.entity.Doctor;
import com.aaspaasdoctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl {

	@Autowired
	DoctorRepository doctorRepository ;
	
	public List<Doctor> findAllDoctors() {
		return (List<Doctor>) doctorRepository.findAll();
	}
	
}
