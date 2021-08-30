package com.myapp.foodieapp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiException {

	private final HttpStatus httpStatus;
	private final String message;
	private final int status;
	private final Date timeStamp;
	
	public ApiException(String message, HttpStatus httpStatus, int status) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.status = status;
		this.timeStamp = new Date();
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}

}