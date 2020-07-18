package com.example.demo.exception;

public class PersonNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -9079454849611061074L;
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
	public PersonNotFoundException(String message) {
		super(message);
	}
	public PersonNotFoundException() {
		super();
	}
	
	public PersonNotFoundException(String code,String message) {
		 
		this.code=code;
		this.message=message;
		
		
		
	}

	

}
