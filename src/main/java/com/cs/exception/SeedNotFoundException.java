package com.cs.exception;

public class SeedNotFoundException extends RuntimeException{
	public SeedNotFoundException()
	{
		super();
	}
	public SeedNotFoundException(String message)
	{
		super(message);
	}
	public SeedNotFoundException(Throwable cause)
	{
		super(cause);
	}
}