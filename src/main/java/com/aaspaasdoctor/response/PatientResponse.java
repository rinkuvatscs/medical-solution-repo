package com.aaspaasdoctor.response;

public class PatientResponse {
	
	
	private String message ;
	
	public PatientResponse(){
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PatientResponse(String message) {
		this.message = message ;
	}

}
