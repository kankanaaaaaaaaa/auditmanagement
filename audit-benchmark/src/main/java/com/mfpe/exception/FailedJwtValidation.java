package com.mfpe.exception;

public class FailedJwtValidation extends Exception{
	public FailedJwtValidation() {
		super("Failed to validate the JWT");
	}
	public FailedJwtValidation(String message) {
		super(message);
	}
}
