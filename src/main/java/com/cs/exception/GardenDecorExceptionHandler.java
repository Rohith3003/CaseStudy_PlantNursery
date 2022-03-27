package com.cs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cs.bean.GardenDecorErrorResponse;

@ControllerAdvice
public class GardenDecorExceptionHandler 
{
	@ExceptionHandler
	public ResponseEntity<GardenDecorErrorResponse> handleException(GardenDecorException exception) 
	{
		GardenDecorErrorResponse error = new GardenDecorErrorResponse();
		error.setMessage(exception.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
