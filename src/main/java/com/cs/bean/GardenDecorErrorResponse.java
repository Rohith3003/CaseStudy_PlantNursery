package com.cs.bean;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * This class is for the Garden Decor Error Response
 * @author Mayank Kumar(Employee ID: 46191925)
 *
 */
@Data
public class GardenDecorErrorResponse 
{
	private String message;
	private LocalDateTime timeStamp;
}
