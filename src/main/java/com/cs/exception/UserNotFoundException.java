package com.cs.exception;

/**
 * This is a user defined exception class used to generate customized
 * UserNotFound Exceptions
 * 
 * @author Rohith(Employee id: 46191986)
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}

}
