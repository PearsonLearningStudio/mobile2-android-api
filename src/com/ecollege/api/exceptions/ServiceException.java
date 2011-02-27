package com.ecollege.api.exceptions;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1664061046918224725L;

	public ServiceException(String string) {
		super(string);
	}

	public ServiceException(Exception e) {
		super(e);
	}
	
	public ServiceException(String s, Exception e) {
		super(s, e);
	}

}
