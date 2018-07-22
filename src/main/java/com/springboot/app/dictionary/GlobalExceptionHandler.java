package com.springboot.app.dictionary;

import java.util.Date;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HttpClientErrorException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorDetails> clientErrorExceptionHandler(Exception ex, HttpServletRequest request) {
		return new ResponseEntity<ErrorDetails>(new ErrorDetails("Error occurred while fetching the dictionary details", new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.name()), HttpStatus.NOT_FOUND);
	}
}
