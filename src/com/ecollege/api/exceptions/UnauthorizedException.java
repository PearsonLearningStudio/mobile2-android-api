package com.ecollege.api.exceptions;

import com.ecollege.api.ECollegeHttpResponse;

public class UnauthorizedException extends ServiceException {

	private static final long serialVersionUID = 1232422310090747961L;

	public UnauthorizedException(ECollegeHttpResponse response) {
		super(response);
	}
}
