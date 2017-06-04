package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.PatientAddress;

public interface PatientAddressRepository extends CrudRepository<PatientAddress, Integer> {

//DoctorAddress findByPId(Integer pId) ;
	
	void deleteByPId(Integer pId) ;
	
}
