package com.cs.bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FertilizerErrorResponse {

	private int status;
	private String message;
	private LocalDateTime timeStamp;
}
