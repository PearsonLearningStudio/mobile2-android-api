package com.ecollege.api.exceptions;

import com.ecollege.api.ECollegeHttpResponse;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1664061046918224725L;

	protected ECollegeHttpResponse response;
	
	public ServiceException(ECollegeHttpResponse response) {
		super(response.getResponse().getStatusLine().getReasonPhrase());
		this.response = response;
	}
	
	public ServiceException(String string) {
		super(string);
	}

	public ServiceException(Exception e) {
		super(e);
	}
	
	public ServiceException(String s, Exception e) {
		super(s, e);
	}

	public ECollegeHttpResponse getResponse() {
		return response;
	}
}
