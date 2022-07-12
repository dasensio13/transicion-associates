package org.transicion.portillo.web.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleException(EmptyResultDataAccessException e) {
		return new ResponseEntity<>("Exception retrieving data " + e.getMessage(), HttpStatus.NOT_FOUND);
	};

}
