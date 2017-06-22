package com.aaspaasdoctor.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.aaspaasdoctor.entity.Doctor;
import com.aaspaasdoctor.entity.DoctorAddress;
import com.aaspaasdoctor.entity.Login;
import com.aaspaasdoctor.exception.BadRequestException;
import com.aaspaasdoctor.location.response.LocationResponse;
import com.aaspaasdoctor.location.service.LocationService;
import com.aaspaasdoctor.repository.DoctorAddressRepository;
import com.aaspaasdoctor.repository.DoctorRepository;
import com.aaspaasdoctor.utility.BeanMapperUtility;

@Service
@Transactional
public class DoctorServiceImpl {

	static final Logger LOGGER = LoggerFactory
			.getLogger(DoctorServiceImpl.class);
	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	DoctorAddressRepository doctorAddressRepository;

	@Autowired
	LoginServiceImpl loginServiceImpl;

	@Autowired
	BeanMapperUtility beanMapperUtility;

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
			doctorAddressRepository.deleteByDId(doctorId);
			doctorRepository.delete(doctorId);
			return DOCTOR_DELETED;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_ID);
		}
	}

	public String deleteDoctorByAadhaar(String aadhaar) {
		Doctor doctor = doctorRepository.findByAadhaar(aadhaar);
		if (doctor != null) {
			doctorAddressRepository.deleteByDId(doctor.getdId());
			doctorRepository.deleteByAadhaar(aadhaar);
			return DOCTOR_DELETED;
		} else {
			throw new BadRequestException(INVALID_DOCTOR_AADHAAR);
		}
	}

	public String deleteDoctorByMobile(String mobile) {
		Doctor doctor = doctorRepository.findByMobile(mobile);

		if (doctor != null) {
			doctorAddressRepository.deleteByDId(doctor.getdId());
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

	public Doctor updateDoctorRepo(Doctor doctor) {
		validateDoctor(doctor);

		Doctor tempDoctor = findDoctorById(doctor.getdId());
		try {
			BeanMapperUtility.copyPropertiesIgnoreNull(doctor, tempDoctor);
            tempDoctor.setUpdatedDate(Calendar.getInstance().getTime());
			updateDoctorAddressRepo(tempDoctor);

			doctorRepository.save(tempDoctor);
			
			Login login = new Login();
			login.setAadhaar(tempDoctor.getAadhaar());
			login.setEmail(tempDoctor.getEmail());
			login.setMobile(tempDoctor.getMobile());
			login.setPassword(tempDoctor.getPassword());
			loginServiceImpl.addLogin(login);
			return tempDoctor;

		} catch (IllegalAccessException | InvocationTargetException e) {
			LOGGER.error("Doctor details not correct for {} with Error {}",
					doctor.getdId(), e);
			throw new BadRequestException(
					"Doctor Details are not correct please try again ");
		}

	}

	public String deleteDoctor(Doctor doctor) {
		doctorRepository.delete(doctor);
		return "Doctor deleted Sucessfully";
	}

	private void updateDoctorAddressRepo(Doctor doctor) {

		if (doctor.getDoctorAddress().getCity() != null
				|| doctor.getState() != null
				|| doctor.getDoctorAddress().getPin() != null) {
			LocationResponse locationResponse = locationService
					.getGeoCodeFromAddress(createAddress(doctor));
			doctor.getDoctorAddress().setLongitude(
					locationResponse.getResults().get(0).getGeometry()
							.getLocation().getLng());
			doctor.getDoctorAddress().setLongitude(
					locationResponse.getResults().get(0).getGeometry()
							.getLocation().getLng());
		}
		if (doctor.getDoctorAddress().getDoctorAddressCreateDate() != null) {
			doctor.getDoctorAddress().setDoctorAddressCreateDate(
					Calendar.getInstance().getTime());
		}
		doctor.setUpdatedDate(Calendar.getInstance().getTime());
	}

	private String createAddress(Doctor doctor) {
		return doctor.getClinic() + ", " + doctor.getDoctorAddress().getCity()
				+ " ," + doctor.getState() + ", India";
	}

	public Doctor doctorSignUp(Doctor doctor) {

		Doctor tempDoctor = doctorRepository.save(doctor);
		tempDoctor.setCreatedDate(Calendar.getInstance().getTime());
		Login login = new Login();
		login.setAadhaar(doctor.getAadhaar());
		login.setEmail(doctor.getEmail());
		login.setMobile(doctor.getMobile());
		login.setPassword(doctor.getPassword());
		login.setType("d");
		login.setTypeId(doctor.getdId());
		loginServiceImpl.addLogin(login);

		DoctorAddress doctorAddress = new DoctorAddress();
		doctorAddress.setdId(tempDoctor.getdId());
		doctorAddressRepository.save(doctorAddress);
		tempDoctor.setPassword(login.getPassword());
		return tempDoctor;

	}

	public List<Doctor> getRecentDoctors(Integer days) {
		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.DATE, -days);
		return doctorRepository.findByCreatedDateBetween(startDate.getTime(),
				Calendar.getInstance().getTime());
	}

	public String forgotPassword(String mobile) {

		Doctor doctor = doctorRepository.findByMobile(mobile);
		if (doctor != null) {
			return null;
		} else {
			throw new BadRequestException("Mobile is not registered");
		}
	}

}
