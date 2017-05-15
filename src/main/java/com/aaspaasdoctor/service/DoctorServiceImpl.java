package com.aaspaasdoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaspaasdoctor.entity.Doctor;
import com.aaspaasdoctor.exception.BadRequestException;
import com.aaspaasdoctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl {

	@Autowired
	DoctorRepository doctorRepository;

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
	
	
//For Dyanamic
	/*O
	public List<Doctor> getDoctors(Doctor doctor) {
		int rowupdate = 0;
		if (doctor.getAadhaar() != null) {
			return getDoctorsByAadhaarNumber(doctor);
		}
		if (!StringUtils.isEmpty(doctor.getMobile())) {
			return getDoctorsByMobile(doctor);
		}
		if (!StringUtils.isEmpty(doctor.getdId()) && doctor.getdId() > 0) {
			return getDoctorsByDoctorId(doctor);
		}
		if (!StringUtils.isEmpty(doctor.getEmail())) {
			return getDoctorsByEmail(doctor);
		}
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder(QueryConstants.GET_DOCTORS);

		if (!StringUtils.isEmpty(doctor)) {

			rowupdate = appendDoctorNameWithLike(rowupdate, doctor, query, args);
			rowupdate = appendDoctorIsGovernmentServent(rowupdate, doctor,
					query, args);
			rowupdate = appendDoctorHomeAddressWithLike(rowupdate, doctor,
					query, args);
			rowupdate = appendDoctorExpertiseWithLike(rowupdate, doctor, query,
					args);
			rowupdate = appendDoctorOneTimeFee(rowupdate, doctor, query, args);
			appendDoctorClinicWithLike(rowupdate, doctor, query, args);

			return jdbcTemplate.query(query.toString(), new DoctorExtractor(),
					args.toArray());

		} else {
			throw new BadRequestException(
					"PLease provide proper detail for Doctor");
		}
	} */

}
