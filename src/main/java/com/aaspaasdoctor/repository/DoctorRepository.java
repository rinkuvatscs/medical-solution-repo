package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor	, Integer>{

	
}
