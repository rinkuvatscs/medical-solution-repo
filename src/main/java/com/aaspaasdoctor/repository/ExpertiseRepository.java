package com.aaspaasdoctor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Expertise;

public interface ExpertiseRepository extends CrudRepository<Expertise, Integer>{

	List<Expertise> findByApproved(Integer approved) ;
	
	Expertise findByExpertiseEqualsIgnoreCase(String expertise) ;
}
