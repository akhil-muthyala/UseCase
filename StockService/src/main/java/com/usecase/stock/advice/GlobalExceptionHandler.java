package com.usecase.stock.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.usecase.stock.exceptions.NotFoundException;
import com.usecase.stock.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handle(NotFoundException e) {
		return new ResponseEntity<ErrorResponse>(
			new ErrorResponse(e.getMessage(), LocalDateTime.now()), 
			HttpStatus.OK
		);
	}
	
//	@ExceptionHandler(UsernameNotFoundException.class)
//	public ResponseEntity<ErrorResponse> handle(UsernameNotFoundException e) {
//		return new ResponseEntity<ErrorResponse>(
//			new ErrorResponse(e.getMessage(), LocalDateTime.now()), 
//			HttpStatus.OK
//		);
//	}
//	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handle(Exception e) {
		return new ResponseEntity<ErrorResponse>(
			new ErrorResponse(e.getMessage(), LocalDateTime.now()), 
			HttpStatus.OK
		);
	}
	
}
