/*package com.aaspaasdoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Expertise;
import com.aaspaasdoctor.service.ExpertiseServiceImpl;

@RestController
@RequestMapping("/api/expertise")
public class ExpertiseController {

	@Autowired
	private ExpertiseServiceImpl expertiseServiceImpl;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/all/expertisation")
	@ResponseBody
	public List<Expertise> getAllExpertisations() {

		return expertiseServiceImpl.getAllExpertized();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/add/{expertise}/expertisation")
	@ResponseBody
	public Expertise addExpertisation(@PathVariable String expertise) {

		return expertiseServiceImpl.addExpertise(new Expertise(expertise));
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/all/unapproved/expertisation")
	@ResponseBody
	public List<Expertise> getAllUnApprovedExpertisations() {

		return expertiseServiceImpl.getUnApprovedExpertise();
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/approve/{expertise}/expertisation")
	@ResponseBody
	public Expertise addExpertisation(@PathVariable Integer expertiseId) {

		return expertiseServiceImpl
				.approveExpertise(new Expertise(expertiseId));
	}
}
*/