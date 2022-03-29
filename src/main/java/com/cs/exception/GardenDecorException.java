package com.cs.exception;
/**
 *  This is a user defined exception class used to generate customized gardendecor exceptions
 * @author Mayank Kumar(Employee ID: 46191925)
 *
 */
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
