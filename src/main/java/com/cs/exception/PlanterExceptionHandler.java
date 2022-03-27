package com.cs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cs.bean.PlanterErrorResponse;

@ControllerAdvice
public class PlanterExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<PlanterErrorResponse> handleException(PlanterNotFoundException exception)
	{
		PlanterErrorResponse error=new PlanterErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<PlanterErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
}
