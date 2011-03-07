package com.ecollege.api.exceptions;

import com.ecollege.api.ECollegeHttpResponse;

public class NotFoundException extends ServiceException {

	private static final long serialVersionUID = 4383036981537835047L;

	public NotFoundException(ECollegeHttpResponse response) {
		super(response);
	}

}

