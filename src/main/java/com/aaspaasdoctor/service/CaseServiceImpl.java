package com.aaspaasdoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaspaasdoctor.entity.Cases;
import com.aaspaasdoctor.repository.CaseRepository;

@Service
@Transactional
public class CaseServiceImpl {

	@Autowired
	private CaseRepository caseRepository;

	public Cases createCase(Cases cases) {
		return caseRepository.save(cases);
	}

	public List<Cases> getCasesByDoctor(Integer doctorId) {
		return caseRepository.findByDoctorId(doctorId);
	}

	public List<Cases> getCasesByPatient(Integer patientId) {
		return caseRepository.findByPatientId(patientId);
	}

	public Cases closeCase(Integer caseId) {
		return openOrClose(caseId, true);
	}

	public Cases reopenCase(Integer caseId) {
		return openOrClose(caseId, false);
	}

	public Cases updateCase(Cases cases) {
		Cases tempCases = caseRepository.findOne(cases.getCaseId());
		if (tempCases != null && tempCases.getCaseId() != null) {
			tempCases.setClosed(cases.getClosed());
			tempCases.setDoctorId(cases.getDoctorId());
			tempCases.setPatientId(cases.getPatientId());
			tempCases.setPrecaution(cases.getPrecaution());
			return caseRepository.save(tempCases);
		}
		return new Cases();
	}

	private Cases openOrClose(Integer caseId, boolean isOpen) {
		Cases tempCases = caseRepository.findOne(caseId);
		if (tempCases != null && tempCases.getCaseId() != null) {
			if (isOpen) {
				tempCases.setClosed(0);
				return caseRepository.save(tempCases);
			} else {
				tempCases.setClosed(1);
				return caseRepository.save(tempCases);
			}
		}
		return new Cases();
	}

}
