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

import com.aaspaasdoctor.entity.Notification;
import com.aaspaasdoctor.service.NotificationServiceImpl;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

	@Autowired
	NotificationServiceImpl notificationServiceImpl;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/add/notification")
	@ResponseBody
	public Notification addMessageForDoctorOrPatient(@RequestBody Notification notification) {
		return notificationServiceImpl.addNotification(notification);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/Notification/patient/{pId}/id")
	@ResponseBody
	public List<Notification> getNotificationforPatient(@PathVariable int pId) {
		return notificationServiceImpl.findByPatientId(pId);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/update/notification")
	@ResponseBody
	public Notification updateNotification(@RequestBody Notification notification) {
		return notificationServiceImpl.updateNotification(notification);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/get/notification/doctor/{dId}/id")
	@ResponseBody
	public List<Notification> getNotificationforDoctor(@PathVariable int dId) {
		return notificationServiceImpl.findByDoctorId(dId);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value = "/delete/notification/{notificationId}")
	@ResponseBody
	public Notification deleteNotification(@PathVariable Integer notificationId) {
		return notificationServiceImpl.deleteByNotificationId(notificationId);
	}
}
