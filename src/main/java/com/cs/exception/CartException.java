package com.cs.exception;

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
