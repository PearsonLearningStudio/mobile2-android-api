package com.ecollege.api.exceptions;

public class UnauthorizedException extends ServiceException {

	private static final long serialVersionUID = 1232422310090747961L;

	public UnauthorizedException(String string) {
		super(string);
	}

	public UnauthorizedException(Exception e) {
		super(e);
	}
	
	public UnauthorizedException(String s, Exception e) {
		super(s, e);
	}
}
