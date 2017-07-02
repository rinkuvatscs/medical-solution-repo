package com.aaspaasdoctor.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.aaspaasdoctor.entity.Login;
import com.aaspaasdoctor.entity.Patient;
import com.aaspaasdoctor.entity.PatientAddress;
import com.aaspaasdoctor.exception.BadRequestException;
import com.aaspaasdoctor.location.response.LocationResponse;
import com.aaspaasdoctor.location.service.LocationService;
import com.aaspaasdoctor.repository.PatientAddressRepository;
import com.aaspaasdoctor.repository.PatientRepository;
import com.aaspaasdoctor.utility.BeanMapperUtility;

@Service
public class PatientServiceImpl {

	static final Logger LOGGER = LoggerFactory
			.getLogger(PatientServiceImpl.class);
	@Autowired
	PatientRepository patientRepository;

	@Autowired
	PatientAddressRepository patientAddressRepository;

	@Autowired
	LoginServiceImpl loginServiceImpl;

	@Autowired
	LocationService locationService;

	public List<Patient> findAllPatients() {
		return (List<Patient>) patientRepository.findAll();
	}

	public Patient addPatient(Patient patient) {

		return patientRepository.save(patient);
	}

	public Patient getPatientByAadhaar(String aadhaar) {

		return patientRepository.findByAadhaar(aadhaar);
	}

	public Patient getPatientByMobile(String mobile) {

		return patientRepository.findByMobile(mobile);
	}

	public Patient getPatientById(Integer id) {

		return patientRepository.findOne(id);
	}

	public Patient getPatientByEmail(String email) {

		return patientRepository.findByEmail(email);
	}

	public List<Patient> getPatientByName(String name) {

		return patientRepository.findByNameContaining(name);
	}

	public Patient patientSignUp(Patient patient) {
		Patient tempPatient = patientRepository.save(patient);
		Login login = new Login();
		login.setEncode(true);
		login.setAadhaar(patient.getAadhaar());
		login.setEmail(patient.getEmail());
		login.setMobile(patient.getMobile());
		login.setPassword(patient.getPassword());
		login.setType("d");
		login.setTypeId(patient.getpId());
		loginServiceImpl.addLogin(login);
		
		PatientAddress patientAddress = new PatientAddress() ;
		patientAddress.setpId(tempPatient.getpId());
		patientAddressRepository.save(patientAddress);
		tempPatient.setPassword(login.getPassword());
		return tempPatient;
	}

	public Patient updatePatient(Patient patient) {

		validatePatient(patient);
		Patient tempPatient = getPatientById(patient.getpId());
		try {
			BeanMapperUtility.copyPropertiesIgnoreNull(patient, tempPatient);

			updatePatientAddressRepo(tempPatient);
			patientRepository.save(tempPatient);

			Login login = new Login();
			login.setAadhaar(tempPatient.getAadhaar());
			login.setEmail(tempPatient.getEmail());
			login.setMobile(tempPatient.getMobile());
			login.setPassword(tempPatient.getPassword());
			login.setType("p");
			login.setTypeId(tempPatient.getpId());
			loginServiceImpl.addLogin(login);
			return tempPatient;
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOGGER.error("Patient details not correct for {} with Error {}",
					patient.getpId(), e);
			throw new BadRequestException(
					"Patient Details are not correct please try again ");
		}
	}

	public Patient deletePatientById(Integer id) {
		Patient patient = getPatientById(id);
		if (patient != null) {
			patientAddressRepository.deleteByPId(id);
			patientRepository.delete(id);
			return patient;
		} else {
			return patient;
		}

	}

	private void validatePatient(Patient patient) {
		if (!StringUtils.isEmpty(patient.getEmail())
				&& !StringUtils.isEmpty(getPatientByEmail(patient.getEmail()))) {
			throw new BadRequestException("Updated Email ID already registered");
		}
		if (!StringUtils.isEmpty(patient.getAadhaar())
				&& !StringUtils.isEmpty(getPatientByAadhaar(patient
						.getAadhaar()))) {
			throw new BadRequestException("Updated Aadhaar already registered");
		}
		if (!StringUtils.isEmpty(patient.getMobile())
				&& !StringUtils
						.isEmpty(getPatientByMobile(patient.getMobile()))) {
			throw new BadRequestException(
					"Updated Mobile Number already registered ");
		}
	}

	private String createAddress(Patient patient) {
		return patient.getPatientAddress().getHomeAddress() + ", "
				+ patient.getPatientAddress().getCity() + " ,"
				+ patient.getPatientAddress().getState() + ", India";
	}

	private void updatePatientAddressRepo(Patient patient) {

		if (patient.getPatientAddress().getCity() != null
				|| patient.getPatientAddress().getState() != null
				|| patient.getPatientAddress().getPin() != null) {
			LocationResponse locationResponse = locationService
					.getGeoCodeFromAddress(createAddress(patient));
			patient.getPatientAddress().setLongitude(
					locationResponse.getResults().get(0).getGeometry()
							.getLocation().getLng());
			patient.getPatientAddress().setLongitude(
					locationResponse.getResults().get(0).getGeometry()
							.getLocation().getLng());
		}
		if (patient.getPatientAddress().getPatientAddressCreateDate() != null) {
			patient.getPatientAddress().setPatientAddressCreateDate(
					Calendar.getInstance().getTime());
		}
		patient.setUpdatedDate(Calendar.getInstance().getTime());
	}

}
