package com.ecollege.api.exceptions;

import com.ecollege.api.ECollegeHttpResponse;

@SuppressWarnings("serial")
public class IncorrectCredentialsException extends ServiceException {
	
	public IncorrectCredentialsException(ECollegeHttpResponse response) {
		super(response);
	}

}

