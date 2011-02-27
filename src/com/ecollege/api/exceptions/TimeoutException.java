package com.ecollege.api.exceptions;

public class TimeoutException extends ServiceException {

	private static final long serialVersionUID = -5389423166139123069L;

	public TimeoutException(String string) {
		super(string);
	}

	public TimeoutException(Exception e) {
		super(e);
	}
	
	public TimeoutException(String s, Exception e) {
		super(s, e);
	}

}
