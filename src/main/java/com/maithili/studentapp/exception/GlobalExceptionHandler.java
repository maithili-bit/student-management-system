package com.maithili.studentapp.exception;

import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public org.springframework.http.ResponseEntity<String> handleStudentNotFound(
	        StudentNotFoundException ex) {

	    return new org.springframework.http.ResponseEntity<>(
	            ex.getMessage(),
	            org.springframework.http.HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public org.springframework.http.ResponseEntity<Map<String, String>> 
	handleValidationException(MethodArgumentNotValidException ex){

	    Map<String, String> errors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors().forEach(error -> {
	        errors.put(error.getField(), error.getDefaultMessage());
	    });

	    return new org.springframework.http.ResponseEntity<>(errors,
	            org.springframework.http.HttpStatus.BAD_REQUEST);
	}
}