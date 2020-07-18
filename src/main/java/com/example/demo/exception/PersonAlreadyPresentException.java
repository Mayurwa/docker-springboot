package com.example.demo.exception;

public class PersonAlreadyPresentException extends RuntimeException {
	private static final long serialVersionUID = -9079454849611061094L;
	private String code;
	private String message;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PersonAlreadyPresentException() {

	}

	public PersonAlreadyPresentException(String message) {
		this.message=message;
		
	}

	public PersonAlreadyPresentException(String code, String message) {
		this.message=message;
		this.code=code;

	}

	
}
