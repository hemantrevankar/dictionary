package com.springboot.app.dictionary.test;

public class ExceptionResponse {
	private String errorMessage;
	private String url;
	public ExceptionResponse(String errorMessage, String url) {
		this.errorMessage = errorMessage;
		this.url = url;
	}
	public ExceptionResponse() {
	}
	
}
