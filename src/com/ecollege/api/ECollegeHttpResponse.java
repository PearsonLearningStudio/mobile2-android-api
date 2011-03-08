package com.ecollege.api;

import org.apache.http.HttpResponse;

public class ECollegeHttpResponse {

	private HttpResponse response;
	private String responseContent;
	
	public HttpResponse getResponse() {
		return response;
	}
	public void setResponse(HttpResponse response) {
		this.response = response;
	}
	public String getResponseContent() {
		return responseContent;
	}
	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}
	
}
