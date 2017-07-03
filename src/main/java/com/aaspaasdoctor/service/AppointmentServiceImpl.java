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

	private static final String ACTIVE_STATUS = "Y";

	private static final String INACTIVE_STATUS = "N";
	@Autowired
	AppointmentRepository appointmentRepository;

	public Appointment findByAppointmentId(int appointmentId) {
		return appointmentRepository.findByAppointmentIdAndStatus(
				appointmentId, ACTIVE_STATUS);

	}

	public List<Appointment> findByPatientId(Integer patientId) {
		return appointmentRepository.findByPIdAndStatus(patientId,
				ACTIVE_STATUS);
	}

	public List<Appointment> findByDoctorId(Integer doctorId) {
		return appointmentRepository
				.findByDIdAndStatus(doctorId, ACTIVE_STATUS);
	}

	public Appointment cancelAppointment(Integer appointmentId) {
		Appointment appointment = appointmentRepository.findOne(appointmentId);
		if (appointment != null) {
			appointment.setStatus(INACTIVE_STATUS);
			appointmentRepository.save(appointment);
		}
		return appointment;
	}

	public Appointment makeAppointment(Appointment appointment) {
		appointment.setStatus(ACTIVE_STATUS);
		return appointmentRepository.save(appointment);
	}

	public Appointment changeStatusToActive(int appointmentId) {
		Appointment appointment = appointmentRepository.findOne(appointmentId);
		if (appointment != null) {
			appointment.setStatus(ACTIVE_STATUS);
			appointment = appointmentRepository.save(appointment);
		}

		return appointment;
	}
}
