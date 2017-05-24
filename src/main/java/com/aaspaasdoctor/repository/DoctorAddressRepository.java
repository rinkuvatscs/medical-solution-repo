package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.DoctorAddress;

public interface DoctorAddressRepository extends CrudRepository<DoctorAddress, Integer>{

	DoctorAddress findByDId(Integer dId) ;
	
	void deleteByDId(Integer dId) ;
}
