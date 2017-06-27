package com.aaspaasdoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaspaasdoctor.entity.Notification;
import com.aaspaasdoctor.repository.NotificationRepository;

@Service
@Transactional
public class NotificationServiceImpl {

	@Autowired
	private NotificationRepository notificationRepository;

	public Notification addNotification(Notification notification) {
		return notificationRepository.save(notification);
	}

	public List<Notification> findByPatientId(int pId) {
		return notificationRepository.findByPatientId(pId);
	}

	public Notification updateNotification(Notification notification) {
		Notification tempNotification = notificationRepository.findOne(notification.getId());

		if (tempNotification != null && notification.getNotification() != null) {
			tempNotification.setNotification(notification.getNotification());
			tempNotification.setStatus(notification.getStatus());
			return notificationRepository.save(tempNotification);
		}
		return new Notification();
	}

	public List<Notification> findByDoctorId(int dId) {
		return notificationRepository.findByDoctorId(dId);
	}

	public Notification deleteByNotificationId(Integer notificationId) {
		Notification notification = notificationRepository.findOne(notificationId);
		if (notification != null) {
			notificationRepository.delete(notification);
			return notification;
		} else {
			return new Notification();
		}
	}

}
