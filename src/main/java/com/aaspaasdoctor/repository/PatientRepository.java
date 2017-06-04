package com.aaspaasdoctor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

	Patient findByAadhaar(String aadhaar);

	Patient findByMobile(String mobile);

	Patient findByEmail(String email);
	
	List<Patient> findByNameContaining(String name) ;
}
