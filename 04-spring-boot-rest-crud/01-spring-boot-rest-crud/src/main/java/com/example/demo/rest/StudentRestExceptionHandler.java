package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//this class is Global Exception class
@ControllerAdvice
public class StudentRestExceptionHandler {
	
	// Add an Exception handler using @ExceptionHandler
	// ResponseEntity represents the whole HTTP response: status code, headers, and body.
	@ExceptionHandler
	public ResponseEntity<StudentErrorRespone> handleException(StudentNotFoundException exc) {
		// create a studentErrorRespone
		StudentErrorRespone error = new StudentErrorRespone();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		// return responseEnity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// Add another Exception handler .... to catch any exception (catch all)
	public ResponseEntity<StudentErrorRespone> handleException(Exception exc) {

		// create a studentErrorRespone
		StudentErrorRespone error = new StudentErrorRespone();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		// return responseEnity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
