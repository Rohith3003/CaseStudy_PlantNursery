package com.cs.exception;

/**
 * This is a user defined exception class used to generate customized cart exceptions
 * @author Mayank Kumar(Employee ID: 46191925)
 *
 */
@SuppressWarnings("serial")
public class CartException extends RuntimeException
{

	public CartException() 
	{
		super();
	}

	public CartException(String message) 
	{
		super(message);
	}

	public CartException(Throwable cause) 
	{
		super(cause);
	}

}
