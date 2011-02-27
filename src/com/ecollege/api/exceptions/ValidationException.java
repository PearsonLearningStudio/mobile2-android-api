package com.ecollege.api.exceptions;

public class ValidationException extends ServiceException {

	private static final long serialVersionUID = 5269568458581310307L;
	
	public String validationField;
	public String validationMessage;

	public ValidationException(String string) {
		super(string);
	}

	public ValidationException(Exception e) {
		super(e);
	}
	
	public ValidationException(String s, Exception e) {
		super(s, e);
	}

}

