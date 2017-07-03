package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	java.util.List<Appointment> findByPIdAndStatus(Integer patientId, String status);
	
	java.util.List<Appointment> findByDIdAndStatus(Integer doctorId , String status);
	
	Appointment findByAppointmentIdAndStatus(Integer appointmentId , String status) ;
}
