package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {

	java.util.List<Message> findByPatientId(Integer patientId);

	java.util.List<Message> findByDoctorId(Integer doctorId);

	java.util.List<Message> findDoctorByDoctorIdAndStatus(Integer doctorId, Integer status);

	java.util.List<Message> findPatientByPatientIdAndStatus(Integer patientId, Integer status);

}
