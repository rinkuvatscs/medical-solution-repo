package com.aaspaasdoctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Login;
import com.aaspaasdoctor.service.LoginServiceImpl;

@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	LoginServiceImpl loginServiceImpl;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/signup")
	@ResponseBody
	public Login addLogin(@RequestBody Login login) {
		return loginServiceImpl.addLogin(login);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/validate")
	@ResponseBody
	public Login isValidIdentity(@RequestBody Login login) {
		return loginServiceImpl.isValidIdentity(login);
	}

}
