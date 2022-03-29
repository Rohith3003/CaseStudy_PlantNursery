package com.cs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cs.bean.SeedErrorResponse;

@SuppressWarnings("serial")
@ControllerAdvice
public class SeedExceptionHandler extends RuntimeException {

	@ExceptionHandler
	public ResponseEntity<SeedErrorResponse> handleException(SeedNotFoundException exception)
	{
		SeedErrorResponse error=new SeedErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<SeedErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
}