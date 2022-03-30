package com.cs.bean;

import java.time.LocalDateTime;

import lombok.Data;
/**
 * This class is used for generating understandable error messages to user when
 * an exception occurs. Consists of 3 members status, message and timeStamp.

 */
@Data
public class SeedErrorResponse {
	private int status;
	private String message;
	private LocalDateTime timestamp;

}