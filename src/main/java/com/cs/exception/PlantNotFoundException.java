package com.cs.exception;

public class PlantNotFoundException extends RuntimeException{
	public PlantNotFoundException()
	{
		super();
	}
	public PlantNotFoundException(String message)
	{
		super(message);
	}
	public PlantNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
