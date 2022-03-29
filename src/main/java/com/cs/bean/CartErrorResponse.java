package com.cs.bean;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * This class is for the Cart Error Response
 * @author Mayank Kumar(Employee ID: 46191925)
 *
 */
@Data
public class CartErrorResponse 
{
	private String message;
	private LocalDateTime timeStamp;
}
