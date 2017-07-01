package com.aaspaasdoctor.response;

public class AppointmentResponse {

	private String message;

	public AppointmentResponse() {
		super();
	}

	public AppointmentResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
