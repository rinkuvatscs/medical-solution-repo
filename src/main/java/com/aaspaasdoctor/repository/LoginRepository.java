package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Login;

public interface LoginRepository extends CrudRepository<Login, Integer> {

	public Login findByEmailAndType(String email , String type);
	
	public Login findByMobileAndType(String mobile , String type) ;
	
}
