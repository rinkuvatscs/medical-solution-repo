package com.aaspaasdoctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaspaasdoctor.entity.Message;
import com.aaspaasdoctor.service.MessageServiceImpl;

@RestController
@RequestMapping("/api/message")
public class MessageController {

	@Autowired
	MessageServiceImpl messageServiceImpl;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/add/message")
	@ResponseBody
	public Message addMessageForPatient(@RequestBody Message message) {
		return messageServiceImpl.addMessage(message);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/message/patient/{pId}/id")
	@ResponseBody
	public List<Message> getMessageforPatient(@PathVariable int pId) {
		return messageServiceImpl.findByPatientId(pId);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/message")
	@ResponseBody
	public Message updateMessage(@RequestBody Message message) {
		return messageServiceImpl.updateMessage(message);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/message/doctor/{dId}/id")
	@ResponseBody
	public List<Message> getMessageforDoctor(@PathVariable int dId) {
		return messageServiceImpl.findByDoctorId(dId);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/delete/message/{messageId}")
	@ResponseBody
	public Message deleteMessage(@PathVariable Integer messageId) {
		return messageServiceImpl.deleteByMessageId(messageId);
	}

	// To get only those messages whose status is '1' corresponds to doctorId.
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/message/doctor/{dId}/id/{status}/status")
	@ResponseBody
	public List<Message> getMessageforDoctorByDoctorIdAndStatus(@PathVariable int dId, @PathVariable int status) {
		return messageServiceImpl.findDoctorByDoctorIdAndStatus(dId, status);

	}

	// To get only those messages whose status is '1' corresponds to patientId.
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/message/patient/{pId}/id/{status}/status")
	@ResponseBody
	public List<Message> getMessageforPatientByPatientIdAndStatus(@PathVariable int pId, @PathVariable int status) {
		return messageServiceImpl.findPatientByPatientIdAndStatus(pId, status);

	}
}
