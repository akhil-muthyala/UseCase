package com.stockmarket.companydetails.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.stockmarket.companydetails.exception.CompanyCannotBeRegisteredException;
import com.stockmarket.companydetails.exception.CompanyNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CompanyCannotBeRegisteredException.class)
	public ResponseEntity<ErrorResponse> handleCompanyCannotBeRegisteredException(
			CompanyCannotBeRegisteredException companyCannotBeRegisteredException) {
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(companyCannotBeRegisteredException.getMessage(), LocalDateTime.now()),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCompanyNotFoundException(CompanyNotFoundException companyNotFoundException){
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(companyNotFoundException.getMessage(), LocalDateTime.now()),HttpStatus.NOT_FOUND);
	}
}

class ErrorResponse {
	private String meesage;
	private LocalDateTime now;

	public ErrorResponse(String meesage, LocalDateTime now) {
		this.meesage = meesage;
		this.now = now;
	}

	public String getMeesage() {
		return meesage;
	}

	public void setMeesage(String meesage) {
		this.meesage = meesage;
	}

	public LocalDateTime getNow() {
		return now;
	}

	public void setNow(LocalDateTime now) {
		this.now = now;
	}

}