package com.ecollege.api.exceptions;

import com.ecollege.api.ECollegeHttpResponse;

@SuppressWarnings("serial")
public class BadRequestException extends ServiceException {
	
	public BadRequestException(ECollegeHttpResponse response) {
		super(response);
	}

}

