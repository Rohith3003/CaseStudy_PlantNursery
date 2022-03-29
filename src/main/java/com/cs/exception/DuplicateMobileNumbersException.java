package com.cs.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicateMobileNumbersException extends DataIntegrityViolationException {

	private static final long serialVersionUID = 1L;

	public DuplicateMobileNumbersException(String msg) {
		super(msg);
	}

}
