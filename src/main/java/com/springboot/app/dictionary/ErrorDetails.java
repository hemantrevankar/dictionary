package com.springboot.app.dictionary;

import java.util.Date;

public class ErrorDetails {
	private String message;
	private Date timestamp;
	private String details;
	private String status;

	public ErrorDetails(String message, Date timestamp, String details, String status) {
		this.message = message;
		this.timestamp = timestamp;
		this.details = details;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
