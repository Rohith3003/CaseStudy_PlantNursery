package com.cs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cs.bean.OrderErrorResponse;

@ControllerAdvice
public class OrderExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<OrderErrorResponse> handleException(OrderException exception) {
		OrderErrorResponse errorResponse = new OrderErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimeStamp(LocalDateTime.now());

		return new ResponseEntity<OrderErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
