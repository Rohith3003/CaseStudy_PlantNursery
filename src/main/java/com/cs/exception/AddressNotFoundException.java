package com.cs.exception;

/**
 * This is a user defined exception class used to generate customized
 * AddressNotFound Exceptions
 * 
 * @author Rohith(Employee id: 46191986)
 * @version 1.0.0
 * @since 28-08-2022
 *
 */
@SuppressWarnings("serial")
public class AddressNotFoundException extends RuntimeException {

	public AddressNotFoundException() {
		super();
	}

	public AddressNotFoundException(String message) {
		super(message);
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
	}

}
