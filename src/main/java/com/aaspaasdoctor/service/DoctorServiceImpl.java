package com.aaspaasdoctor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.aaspaasdoctor.entity.Doctor;
import com.aaspaasdoctor.entity.Expertise;
import com.aaspaasdoctor.exception.BadRequestException;
import com.aaspaasdoctor.location.response.LocationResponse;
import com.aaspaasdoctor.location.service.LocationService;
import com.aaspaasdoctor.repository.DoctorRepository;
import com.aaspaasdoctor.repository.ExpertiseRepository;

@Service
public class DoctorServiceImpl {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	ExpertiseRepository expertiseRepository;

	@Autowired
	DoctorUtility doctorUtility;

	@Autowired
	LocationService locationService;

	private static final String INVALID_DOCTOR_ID = "Doctor's Id is not valid";
	private static final String INVALID_DOCTOR_AADHAAR = "Doctor's Aadhaar Number is not valid";
	private static final String INVALID_DOCTOR_MOBILE = "Doctor's Mobile Number is not valid";
	private static final String INVALID_DOCTOR_EMAIL = "Doctor's Email is not valid";
	private static final String INVALID_DOCTOR_NAME = "Doctor's Name is not valid";
	private static final String DOCTOR_DELETED = "Doctor Deleted Sucessfuly";
	private static final String INVALID_DOCTOR_EXPERTISE = "Expertise is not valid";
	private static final String INVALID_DOCTOR_FEE = "Fee details are not valid";

	public List<Doctor> findAllDoctors() {
		return (List<Doctor>) doctorRepository.findAll();
	}

	public Doctor findDoctorById(Integer doctorId) {
		Doctor doctor = doctorRepository.findOne(doctorId);
		if (doctor != null) {
			return doctor;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_ID);
		}
	}

	public Doctor findDoctorByAadhaar(String aadhaar) {
		Doctor doctor = doctorRepository.findByAadhaar(aadhaar);
		if (doctor != null) {
			return doctor;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_AADHAAR);
		}
	}

	public Doctor findDoctorByEmail(String email) {
		Doctor doctor = doctorRepository.findByEmail(email);
		if (doctor != null) {
			return doctor;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_EMAIL);
		}

	}

	public Doctor findDoctorByMobile(String mobile) {
		Doctor doctor = doctorRepository.findByMobile(mobile);
		if (doctor != null) {
			return doctor;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_MOBILE);
		}
	}

	public List<Doctor> findDoctorByName(String name) {
		List<Doctor> doctors = doctorRepository.findByNameContaining(name);
		if (doctors != null && !doctors.isEmpty()) {
			return doctors;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_NAME);
		}
	}

	public List<Doctor> findDoctorByExpertise(String expertise) {
		List<Doctor> doctors = doctorRepository
				.findByExpertiseContaining(expertise);
		if (doctors != null && !doctors.isEmpty()) {
			return doctors;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_EXPERTISE);
		}
	}

	public List<Doctor> findDoctorByFee(Integer fee) {
		List<Doctor> doctors = doctorRepository.findByFee(fee);
		if (doctors != null && !doctors.isEmpty()) {
			return doctors;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_FEE);
		}
	}

	public String deleteDoctorById(Integer doctorId) {
		Doctor doctor = doctorRepository.findOne(doctorId);
		if (doctor != null) {
			doctorRepository.delete(doctorId);
			return DOCTOR_DELETED;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_ID);
		}
	}

	public String deleteDoctorByAadhaar(String aadhaar) {
		Doctor doctor = doctorRepository.findByAadhaar(aadhaar);
		if (doctor != null) {
			doctorRepository.deleteByAadhaar(aadhaar);
			return DOCTOR_DELETED;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_AADHAAR);
		}
	}

	public String deleteDoctorByMobile(String mobile) {
		Doctor doctor = doctorRepository.findByMobile(mobile);
		if (doctor != null) {
			doctorRepository.deleteByMobile(mobile);
			return DOCTOR_DELETED;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_MOBILE);
		}
	}

	private void validateDoctor(Doctor doctor) {
		if (!StringUtils.isEmpty(doctor.getEmail())
				&& !StringUtils.isEmpty(findDoctorByEmail(doctor.getEmail()))) {
			throw new BadRequestException("Updated Email ID already registered");
		}
		if (!StringUtils.isEmpty(doctor.getAadhaar())
				&& !StringUtils
						.isEmpty(findDoctorByAadhaar(doctor.getAadhaar()))) {
			throw new BadRequestException("Updated Aadhaar already registered");
		}
		if (!StringUtils.isEmpty(doctor.getMobile())
				&& !StringUtils.isEmpty(findDoctorByMobile(doctor.getMobile()))) {
			throw new BadRequestException(
					"Updated Mobile Number already registered ");
		}
	}

	public String updateDoctor(Doctor doctor) {

		int updateRow = 0;
		String response;
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder("UPDATE doctor SET ");
		if (!StringUtils.isEmpty(doctor)) {

			validateDoctor(doctor);

			updateRow = updateRow
					+ doctorUtility.appendDoctorName(doctor, query, args);
			updateRow = doctorUtility.appendDoctorHomeAddress(updateRow,
					doctor, query, args);
			updateRow = doctorUtility.appendDoctorHighestDegree(updateRow,
					doctor, query, args);
			updateRow = doctorUtility.appendDoctorExpertized(updateRow, doctor,
					query, args);
			updateRow = doctorUtility.appendDoctorIsGovernmentServent(
					updateRow, doctor, query, args);
			updateRow = doctorUtility.appendDoctorOneTimeFee(updateRow, doctor,
					query, args);
			updateRow = doctorUtility.appendDoctorDaysCheckFree(updateRow,
					doctor, query, args);
			updateRow = doctorUtility.appendDoctorClinicAddress(updateRow,
					doctor, query, args);
			updateRow = doctorUtility.appendDoctorMobile(updateRow, doctor,
					query, args);
			updateRow = doctorUtility.appendDoctorAadhaarNumber(updateRow,
					doctor, query, args);
			updateRow = doctorUtility.appendDoctorEmail(updateRow, doctor,
					query, args);
			updateRow = doctorUtility.appendDoctorGender(updateRow, doctor,
					query, args);
			updateRow = doctorUtility.appendDoctorDesc(updateRow, doctor,
					query, args);
			updateRow = doctorUtility.appendDoctorTiming(updateRow, doctor,
					query, args);
			updateRow = doctorUtility.appendDoctorProfilePicPath(updateRow,
					doctor, query, args);
			doctorUtility.appendDoctorDOB(updateRow, doctor, query, args);

			query.append("  WHERE dId = ? ");
			args.add(doctor.getdId());

			// int update = jdbcTemplate.update(query.toString(),
			// args.toArray());
			int update = 1;
			if (update > 0) {

				if (updateDoctorAddress(doctor) > 0) {
					response = "Doctor successfully Updated...!!!";
				} else {
					return "Doctor Address Details not added";
				}
			} else {
				response = "There is some problem, please try again later...!!!";
			}
		} else {
			response = "Doctor details are Empty, provide some details to update....!!!";
		}

		return response;
	}

	private int updateDoctorAddress(Doctor doctor) {
		int updateRow = 0;
		int tempUpdateRow;
		boolean updateLocations = false;
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder("UPDATE doctorAddress SET ");
		updateRow = doctorUtility.appendDoctorExpertized(updateRow, doctor,
				query, args);
		updateRow = doctorUtility.appendDoctorExpertized(updateRow, doctor,
				query, args);
		tempUpdateRow = doctorUtility.appendDoctorCity(updateRow, doctor,
				query, args);
		if (tempUpdateRow > updateRow) {
			updateLocations = true;
			updateRow = tempUpdateRow;
		}
		if (!updateLocations) {
			tempUpdateRow = doctorUtility.appendDoctorPin(updateRow, doctor,
					query, args);
			if (tempUpdateRow > updateRow) {
				updateLocations = true;
				updateRow = tempUpdateRow;
			}
		} else {
			updateRow = doctorUtility.appendDoctorPin(tempUpdateRow, doctor,
					query, args);
		}
		updateRow = doctorUtility.appendDoctorState(updateRow, doctor, query,
				args);
		updateRow = doctorUtility.appendDoctorLandMark(updateRow, doctor,
				query, args);
		if (updateRow > 0) {
			query.append(" , updatedDate = NOW() ");
		}
		if (updateLocations) {
			LocationResponse locationResponse = locationService
					.getGeoCodeFromAddress(createAddress(doctor));
			if (locationResponse != null) {
				doctorUtility.appendDoctorLatitdueAndLogitude(updateRow,
						locationResponse, query, args);
			}
		}
		query.append("  WHERE dId = ? ");
		args.add(doctor.getdId());
		// TODO jdbcTemplate..update(query.toString(), args.toArray());
		return 0;
	}

	private String createAddress(Doctor doctor) {
		return doctor.getClinic() + ", " + doctor.getCity() + " ,"
				+ doctor.getState() + ", India";
	}

	public List<Expertise> getAllExpertized() {
		Integer unApproved = 0;
		return (List<Expertise>) expertiseRepository.findByApproved(unApproved);
	}
	
	public List<Expertise> getUnApprovedExpertise(){
		Integer approved = 1;
		return (List<Expertise>) expertiseRepository.findByApproved(approved);

	}

	public Expertise approveExpertise(Expertise expertise) {
		 Expertise tempExpertise = expertiseRepository.findOne(expertise.getExpertiseId());
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
