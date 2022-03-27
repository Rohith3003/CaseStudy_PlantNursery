package com.cs.bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PlanterErrorResponse {
	//HTTP Status code
	private int status;
	//Custom error message
	private String message;
	//Error triggered time
	private LocalDateTime timestamp;
}
