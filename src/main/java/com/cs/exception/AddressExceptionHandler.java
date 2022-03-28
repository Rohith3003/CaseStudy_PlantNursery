package com.cs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cs.bean.AddressErrorResponse;

/**
 * This class is used to handle exceptions generated by AddressErrorReponse
 * class(com.cs.bean.AddressErrorResponse) and
 * AddressNotFoundException(com.cs.exception.AddressNotFoundException)
 * 
 * @author Rohith(Employee id: 46191986)
 *
 */
@ControllerAdvice
public class AddressExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<AddressErrorResponse> handleException(AddressNotFoundException exception) {
		AddressErrorResponse errorResponse = new AddressErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(LocalDateTime.now());

		return new ResponseEntity<AddressErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
