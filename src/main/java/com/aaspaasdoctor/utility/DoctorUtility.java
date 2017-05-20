/*package com.aaspaasdoctor.utility;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aaspaasdoctor.entity.Doctor;
import com.aaspaasdoctor.location.response.LocationResponse;

@Component
public class DoctorUtility {

	public int appendDoctorName(Doctor doctor, StringBuilder query,
			List<Object> args) {
		if (null != doctor.getName()) {
			query.append(" name = ? ");
			args.add(doctor.getName());
			return 1;
		}
		return 0;
	}

	public int appendDoctorHomeAddress(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getHomeAddress()) {
			if (updateRow > 0) {
				query.append(" , home_address = ? ");
			} else {
				query.append(" home_address = ? ");
			}
			args.add(doctor.getHomeAddress());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorHighestDegree(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getHighestDegree()) {
			if (updateRow > 0) {
				query.append(", highest_degree = ? ");
			} else {
				query.append(" highest_degree = ? ");
			}
			args.add(doctor.getHighestDegree());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorExpertized(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getExpertise()) {
			if (updateRow > 0) {
				query.append(", expertise = ? ");
			} else {
				query.append(" expertise = ? ");
			}
			args.add(doctor.getExpertise().toLowerCase());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorIsGovernmentServent(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getIsGoverment()) {
			if (updateRow > 0) {
				query.append(", gov = ? ");
			} else {
				query.append(" gov = ? ");
			}
			args.add(doctor.getIsGoverment());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorOneTimeFee(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getFee()) {
			if (updateRow > 0) {
				query.append(", fee = ? ");
			} else {
				query.append(" fee = ? ");
			}
			args.add(doctor.getFee());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorDaysCheckFree(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getFreeDay()) {
			if (updateRow > 0) {
				query.append(", free_day = ? ");
			} else {
				query.append(" free_day = ? ");
			}
			args.add(doctor.getFreeDay());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorClinicAddress(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getClinic()) {
			if (updateRow > 0) {
				query.append(", clinic = ? ");
			} else {
				query.append(" clinic = ? ");
			}
			args.add(doctor.getClinic());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorMobile(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getMobile()) {
			if (updateRow > 0) {
				query.append(", mobile = ? ");
			} else {
				query.append(" mobile = ? ");
			}
			args.add(doctor.getMobile());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorAadhaarNumber(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getAadhaar()) {
			if (updateRow > 0) {
				query.append(", adhaar = ? ");
			} else {
				query.append(" adhaar = ? ");
			}
			args.add(doctor.getAadhaar());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorEmail(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getEmail()) {
			if (updateRow > 0) {
				query.append(", email = ? ");
			} else {
				query.append(" email = ? ");
			}
			args.add(doctor.getEmail());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorGender(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getGender()) {
			if (updateRow > 0) {
				query.append(", gender = ? ");
			} else {
				query.append(" gender = ? ");
			}
			args.add(doctor.getGender());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorDesc(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getDesc()) {
			if (updateRow > 0) {
				query.append(", self_desc = ? ");
			} else {
				query.append(" self_desc = ?  ");
			}
			query.append(", updated_date = NOW()");
			args.add(doctor.getDesc());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorTiming(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getTiming()) {
			if (updateRow > 0) {
				query.append(", timing = ? ");
			} else {
				query.append(" timing = ? ");
			}
			args.add(doctor.getTiming());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorProfilePicPath(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getProfilePicPath()) {
			if (updateRow > 0) {
				query.append(", profile_pic_path = ? ");
			} else {
				query.append(" profile_pic_path = ? ");
			}
			args.add(doctor.getProfilePicPath());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorDOB(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getDateOfBrith()) {
			if (updateRow > 0) {
				query.append(", dob = ? ");
			} else {
				query.append(" dob = ? ");
			}
			args.add(doctor.getDateOfBrith());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorCity(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getCity()) {
			if (updateRow > 0) {
				query.append(", city = ? ");
			} else {
				query.append(" city = ? ");
			}
			args.add(doctor.getCity());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorPin(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getPin()) {
			if (updateRow > 0) {
				query.append(", pin = ? ");
			} else {
				query.append(" pin = ? ");
			}
			args.add(doctor.getPin());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorState(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getState()) {
			if (updateRow > 0) {
				query.append(", state = ? ");
			} else {
				query.append(" state = ? ");
			}
			args.add(doctor.getState());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorLandMark(int updateRow, Doctor doctor,
			StringBuilder query, List<Object> args) {
		if (null != doctor.getLandmark()) {
			if (updateRow > 0) {
				query.append(", landmark = ? ");
			} else {
				query.append(" landmark = ? ");
			}
			args.add(doctor.getLandmark());
			return updateRow + 1;
		}
		return updateRow;
	}

	public int appendDoctorLatitdueAndLogitude(int updateRow,
			LocationResponse locationResponse, StringBuilder query,
			List<Object> args) {
		if (null != locationResponse.getResults().get(0).getGeometry()
				.getLocation().getLat()
				&& null != locationResponse.getResults().get(0).getGeometry()
						.getLocation().getLng()) {
			if (updateRow > 0) {
				query.append(", latitude = ? ");
			} else {
				query.append(" latitude = ? ");
			}
			args.add(locationResponse.getResults().get(0).getGeometry()
					.getLocation().getLat());

			query.append(", longitude = ? ");
			args.add(locationResponse.getResults().get(0).getGeometry()
					.getLocation().getLng());
			return updateRow + 1;
		}
		return updateRow;
	}

	

}
*/