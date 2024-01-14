package com.user.service.UserMS.Exception;

public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//extra properties that you want to manage
	public ResourceNotFoundException() {
		super("Resource not found exception !!");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
