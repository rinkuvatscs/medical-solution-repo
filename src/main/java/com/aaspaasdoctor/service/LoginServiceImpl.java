package com.aaspaasdoctor.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaspaasdoctor.entity.Login;
import com.aaspaasdoctor.repository.LoginRepository;

@Service
@Transactional
public class LoginServiceImpl {

	@Autowired
	LoginRepository loginRepository;

	public Login addLogin(Login login) {
		return loginRepository.save(login);
	}

	public Login isValidIdentity(Login login) {
		Login tempLogin;
		if (!StringUtils.isEmpty(login.getEmail())
				&& !StringUtils.isEmpty(login.getType())) {
			tempLogin = loginRepository.findByEmailAndType(login.getEmail(),
					login.getType());

		} else if (!StringUtils.isEmpty(login.getMobile())
				&& !StringUtils.isEmpty(login.getType())) {
			tempLogin = loginRepository.findByMobileAndType(login.getMobile(),
					login.getType());
		} else {
			return null;
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (tempLogin != null
				&& !StringUtils.isEmpty(login.getPassword())
				&& encoder
						.matches(login.getPassword(), tempLogin.getPassword())) {
			return tempLogin;
		} else {
			return new Login();
		}
	}

}
