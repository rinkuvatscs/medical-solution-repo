package com.aaspaasdoctor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer>{
	
	List<Contact> findByEmail(String email); 

}
