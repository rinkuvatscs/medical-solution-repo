package com.aaspaasdoctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.aaspaasdoctor.entity.Cases;

public interface CaseRepository extends CrudRepository<Cases, Integer> {

	java.util.List<Cases> findByPatientId(Integer patientId);

	java.util.List<Cases> findByDoctorId(Integer doctorId);
}
