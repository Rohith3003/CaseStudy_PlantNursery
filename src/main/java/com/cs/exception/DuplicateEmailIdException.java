package com.cs.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicateEmailIdException extends DataIntegrityViolationException {

	private static final long serialVersionUID = 1L;

	public DuplicateEmailIdException(String msg) {
		super(msg);
	}

}
