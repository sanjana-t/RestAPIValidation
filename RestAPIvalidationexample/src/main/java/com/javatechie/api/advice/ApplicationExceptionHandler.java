package com.javatechie.api.advice;

import java.util.HashMap;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javatechie.api.exception.UserException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus; 


@RestControllerAdvice


public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArugment(MethodArgumentNotValidException exception){
		Map<String,String> errorMap = new HashMap<>();
		exception.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(),error.getDefaultMessage());
		});
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserException.class)
	public Map<String,String> handleBusinessException(UserException exception){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("errorMessage",exception.getMessage());
		return errorMap;
	}
}
