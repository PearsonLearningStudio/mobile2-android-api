package com.ecollege.api.exceptions;

public class NotFoundException extends ServiceException {

	private static final long serialVersionUID = 4383036981537835047L;

	public NotFoundException(String string) {
		super(string);
	}

	public NotFoundException(Exception e) {
		super(e);
	}
	
	public NotFoundException(String s, Exception e) {
		super(s, e);
	}

}

