package com.stockmarket.companydetails.exception;

public class CompanyCannotBeRegisteredException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CompanyCannotBeRegisteredException() {
		
	}
	
	public CompanyCannotBeRegisteredException(String message) {
		super(message);
	}

}
