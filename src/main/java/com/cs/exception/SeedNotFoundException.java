package com.cs.exception;

/** Custom runtime exception class, to be thrown when Planter not found.
* @author Palak
*
**/
@SuppressWarnings("serial")
public class SeedNotFoundException extends RuntimeException{
	public SeedNotFoundException()
	{
		super();
	}
	public SeedNotFoundException(String message)
	{
		/**
		 * Parameterized constructor for custom message
		 */
		super(message);
	}
	public SeedNotFoundException(Throwable cause)
	{
		/**
		 * Parameterized constructor for Throwable
		 * @param cause
		 */
		super(cause);
	}
}