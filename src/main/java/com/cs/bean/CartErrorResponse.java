package com.cs.bean;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CartErrorResponse 
{
	private String message;
	private LocalDateTime timeStamp;
}
