package com.aaspaasdoctor.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

	Doctor findByAadhaar(String aadhaar);

	void deleteByAadhaar(String aadhaar);

	Doctor findByMobile(String mobile);

	void deleteByMobile(String mobile);

	Doctor findByEmail(String email);

	List<Doctor> findByFee(Integer fee);

	List<Doctor> findByNameContaining(String name);

	List<Doctor> findByExpertiseContaining(String expertise);
	
	List<Doctor> findByCreatedDateBetween(Date start , Date end) ;
	
}
