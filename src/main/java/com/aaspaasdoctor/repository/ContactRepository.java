package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer>{
	
	Contact findByEmail(String email); 

}
