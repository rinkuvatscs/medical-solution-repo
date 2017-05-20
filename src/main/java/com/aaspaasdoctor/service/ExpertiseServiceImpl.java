package com.aaspaasdoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaspaasdoctor.entity.Expertise;
import com.aaspaasdoctor.exception.BadRequestException;
import com.aaspaasdoctor.repository.ExpertiseRepository;

@Service
public class ExpertiseServiceImpl {

	@Autowired
	ExpertiseRepository expertiseRepository;

	public List<Expertise> getAllExpertized() {
		Integer unApproved = 0;
		return (List<Expertise>) expertiseRepository.findByApproved(unApproved);
	}

	public List<Expertise> getUnApprovedExpertise() {
		Integer approved = 1;
		return (List<Expertise>) expertiseRepository.findByApproved(approved);

	}

	public Expertise approveExpertise(Expertise expertise) {
		Expertise tempExpertise = expertiseRepository.findOne(expertise
				.getExpertiseId());
		tempExpertise.setApproved(1);
		return expertiseRepository.save(tempExpertise);
	}

	public Expertise addExpertise(Expertise expertise) {
		Expertise tempExpertise = expertiseRepository
				.findByExpertiseEqualsIgnoreCase(expertise.getExpertise());
		if (tempExpertise == null) {
			return expertiseRepository.save(expertise);
		} else {
			throw new BadRequestException("Expertise already exists");
		}
	}

}
