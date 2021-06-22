package com.springboot.treino.exceptions;

import java.time.Instant;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AplicationExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity exceptionHandle(Exception e) {
		return new ResponseEntity("Error timestamp:" + Instant.now(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity DataAccessException(Exception e) {
		return new ResponseEntity("Error timestamp:" + Instant.now(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity ViolationException(Exception e) {
		return new ResponseEntity("Error timestamp:" + Instant.now(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity EntityNotFoundException(Exception e) {
		return new ResponseEntity("Error timestamp:" + Instant.now(), HttpStatus.NOT_FOUND);
	}
}
