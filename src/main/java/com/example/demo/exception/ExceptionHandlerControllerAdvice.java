package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler  {
	
	@ExceptionHandler(PersonNotFoundException.class)
	public final ResponseEntity<ErrorResponse> PersonNotFoundException(PersonNotFoundException er)
	{
		ErrorResponse response = new ErrorResponse();
		response.setCode(er.getCode());
		response.setMessage(er.getMessage());
		response.setTimestamp(new Date());
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(PersonAlreadyPresentException.class)
	public final ResponseEntity<ErrorResponse> PersonAlreadyPresentException(PersonAlreadyPresentException er)
	{
		ErrorResponse response = new ErrorResponse();
		response.setCode(er.getCode());
		response.setMessage(er.getMessage());
		response.setTimestamp(new Date());
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.CONFLICT);
		
	}
}
