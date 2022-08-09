package org.transicion.portillo.web.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleException(EmptyResultDataAccessException e) {
		return new ResponseEntity<>("Exception retrieving data " + e.getMessage(), HttpStatus.NOT_FOUND);
	};

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return handleExceptionInternal(ex, getApiError(status, ex), headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return handleExceptionInternal(ex, getApiError(status, ex), headers, status, request);
	}

	private ApiError getApiError(HttpStatus status, Exception ex) {
		String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
		String details = ex.toString();

		return new ApiError(status.value(), message, details);
	}
}
