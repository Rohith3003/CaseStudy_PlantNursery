package com.cs.bean;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * This class is used for generating understandable error messages to user when
 * an exception occurs. Consists of 3 members status, message and timeStamp.
 * 
 * @author Rohith
 * @version 1.0
 * @since 28-03-2022
 *
 */

@Data
public class AddressErrorResponse {

	private int status;
	private String message;
	private LocalDateTime timeStamp;
}
