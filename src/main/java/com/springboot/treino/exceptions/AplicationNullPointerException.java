package com.springboot.treino.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AplicationNullPointerException extends ResponseEntityExceptionHandler  {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity exceptionHandle(Exception e) {
		return new ResponseEntity("Error", HttpStatus.NOT_FOUND);
	}

}
