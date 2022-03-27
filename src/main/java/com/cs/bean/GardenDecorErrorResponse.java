package com.cs.bean;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class GardenDecorErrorResponse 
{
	private String message;
	private LocalDateTime timeStamp;
}
