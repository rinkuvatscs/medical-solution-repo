package com.aaspaasdoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaspaasdoctor.entity.Appointment;
import com.aaspaasdoctor.repository.AppointmentRepository;

@Service
@Transactional
public class AppointmentServiceImpl {

	@Autowired
	AppointmentRepository appointmentRepository;

	public List<Appointment> findByPatientAndDoctorAndPId(int pid) {
		//return appointmentRepository.findByPId(pid);
		return appointmentRepository.findOne(pid);
	}
}
