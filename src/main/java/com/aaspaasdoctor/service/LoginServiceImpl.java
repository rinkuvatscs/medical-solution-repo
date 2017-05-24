package com.aaspaasdoctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaspaasdoctor.entity.Login;
import com.aaspaasdoctor.repository.LoginRepository;

@Service
@Transactional
public class LoginServiceImpl {

	@Autowired
	LoginRepository loginRepository ;
	
	
	
	public Login addLoginDetails(Login login) {
		return loginRepository.save(login) ;
	}
	
}
