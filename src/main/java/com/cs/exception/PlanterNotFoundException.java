package com.cs.exception;

/**
 * Custom runtime exception class, to be thrown when Planter not found.
 * @author Hemanth
 *
 */
@SuppressWarnings("serial")
public class PlanterNotFoundException extends RuntimeException{
	
	public PlanterNotFoundException()
	{
		super();
	}
	/**
	 * Parameterized constructor for custom message
	 */
	public PlanterNotFoundException(String message)
	{
		super(message);
	}
	/**
	 * Parameterized constructor for Throwable
	 * @param cause
	 */
	public PlanterNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
