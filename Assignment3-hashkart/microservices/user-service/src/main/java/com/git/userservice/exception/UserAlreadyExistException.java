package com.git.userservice.exception;

public class UserAlreadyExistException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public UserAlreadyExistException(String msg) {
		this.msg = msg;
	}

	public String getMessage() {
		return this.msg;
	}
}