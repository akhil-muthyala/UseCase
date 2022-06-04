package com.assignment.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.assignment.model.ErrorResponse;
import com.netflix.zuul.exception.ZuulException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handle(Exception e) {
		return new ResponseEntity<ErrorResponse>(
			new ErrorResponse(e.getMessage(), LocalDateTime.now()), 
			HttpStatus.OK
		);
	}
	
	@ExceptionHandler(ZuulException.class)
	public ResponseEntity<ErrorResponse> handle(ZuulException e) {
		return new ResponseEntity<ErrorResponse>(
			new ErrorResponse(e.getMessage(), LocalDateTime.now()), 
			HttpStatus.OK
		);
	}
	
}
