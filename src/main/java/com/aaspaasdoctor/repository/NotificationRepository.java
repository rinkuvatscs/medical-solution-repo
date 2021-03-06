package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {

	java.util.List<Notification> findByPatientId(Integer patientId);

	java.util.List<Notification> findByDoctorId(Integer doctorId);

	java.util.List<Notification> findDoctorByDoctorIdAndStatus(Integer doctorId, Integer status);

	java.util.List<Notification> findPatientByPatientIdAndStatus(Integer patientId, Integer status);

}
