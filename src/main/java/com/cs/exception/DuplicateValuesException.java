package com.cs.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicateValuesException extends DataIntegrityViolationException {

	private static final long serialVersionUID = 1L;

	public DuplicateValuesException(String msg) {
		super(msg);
	}

}
