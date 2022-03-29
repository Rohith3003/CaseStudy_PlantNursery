package com.cs.exception;

@SuppressWarnings("serial")
public class GardenDecorException extends RuntimeException
{

	public GardenDecorException() 
	{
		super();
	}

	public GardenDecorException(String message) 
	{
		super(message);
	}

	public GardenDecorException(Throwable cause) 
	{
		super(cause);
	}

}
