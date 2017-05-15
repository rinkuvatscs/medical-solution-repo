package com.aaspaasdoctor.response;

public class DoctorResponse {

	private String message ;

	public DoctorResponse() {
		
	}
	public DoctorResponse(String message) {
		this.message = message ;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
