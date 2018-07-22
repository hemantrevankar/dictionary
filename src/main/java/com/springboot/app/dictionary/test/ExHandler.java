package com.springboot.app.dictionary.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExHandler {
	@ExceptionHandler({ArithmeticException.class})
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(Exception ex, HttpServletRequest request) {
		return new ExceptionResponse(ex.getMessage(), request.getRequestURI());
	}
}
