package com.assignment.model;

import java.time.LocalDateTime;

public class ErrorResponse{
	private String message;
	private LocalDateTime now;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getNow() {
		return now;
	}
	public void setNow(LocalDateTime now) {
		this.now = now;
	}
	public ErrorResponse(String message, LocalDateTime now) {
		super();
		this.message = message;
		this.now = now;
	}
}