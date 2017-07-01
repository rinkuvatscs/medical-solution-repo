package com.aaspaasdoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Cases;
import com.aaspaasdoctor.service.CaseServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cases")
public class CaseController {

	@Autowired
	private CaseServiceImpl caseServiceImpl;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/create")
	@ApiOperation(value = "create case", notes = "create case by doctor")
	public Cases createCase(@RequestBody Cases cases) {

		return caseServiceImpl.createCase(cases);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{doctorId}/did")
	@ApiOperation(value = "Get case by Doctor", notes = "Get case by doctor Id")
	public List<Cases> getCaseByDoctorId(@RequestParam Integer doctorId) {

		return caseServiceImpl.getCasesByDoctor(doctorId);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/{patientId}/pid")
	@ApiOperation(value = "Get case by Patient", notes = "Get case by Patient Id")
	public List<Cases> getCaseByPatientId(@RequestParam Integer patientId) {

		return caseServiceImpl.getCasesByPatient(patientId);
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "/close/{caseId}")
	@ApiOperation(value = "close case", notes = "close case by doctor")
	public Cases closeCaseByCaseId(@PathVariable Integer caseId) {

		return caseServiceImpl.closeCase(caseId);
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "/reopen/{caseId}")
	@ApiOperation(value = "reopen case", notes = "reopen case by doctor")
	public Cases reopenCaseByCaseId(@PathVariable Integer caseId) {

		return caseServiceImpl.reopenCase(caseId);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/update")
	@ApiOperation(value = "update case", notes = "update case by doctor")
	public Cases updateCase(@RequestBody Cases cases) {

		return caseServiceImpl.updateCase(cases);
	}
}
