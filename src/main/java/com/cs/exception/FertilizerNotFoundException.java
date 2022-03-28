package com.cs.exception;

/**
 * This is a user defined exception class used to generate customized
 * FertilizerNotFound Exceptions
 * 
 * @author Rohith(Employee id: 46191986)
 *
 */
@SuppressWarnings("serial")
public class FertilizerNotFoundException extends RuntimeException {

	public FertilizerNotFoundException() {
		super();
	}

	public FertilizerNotFoundException(String message) {
		super(message);
	}

	public FertilizerNotFoundException(Throwable cause) {
		super(cause);
	}

}
