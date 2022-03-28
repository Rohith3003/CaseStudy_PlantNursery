package com.cs.bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SeedErrorResponse {
	private int status;
	private String message;
	private LocalDateTime timestamp;

}