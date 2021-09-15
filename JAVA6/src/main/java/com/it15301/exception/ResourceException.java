package com.it15301.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceException extends Exception{
	private static final long serialversionUID =1L;
	
	public ResourceException(String message) {
		super(message);
	}

	public ResourceException() {
		// TODO Auto-generated constructor stub
	}
}
