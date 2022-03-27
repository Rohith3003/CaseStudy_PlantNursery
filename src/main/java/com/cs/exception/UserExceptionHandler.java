package com.cs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cs.bean.UserErrorResponse;

public class UserExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exception)
	{
		UserErrorResponse errorResponse = new UserErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<UserErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
