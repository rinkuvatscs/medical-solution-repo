package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	java.util.List<Appointment> findByPId(Integer patientId);
}
