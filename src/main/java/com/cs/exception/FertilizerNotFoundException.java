package com.cs.exception;

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
