package com.ecollege.api.services.multimedia;

import com.ecollege.api.services.BaseService;

public class FetchHtmlByIdService extends BaseService {

	private long courseId;
	private long htmlId;
	
	public FetchHtmlByIdService(long courseId, long htmlId) {
		this.courseId=courseId;
		this.htmlId=htmlId;
	}	

	private String result;
	
	public String getResult() {
		return result;
	}

	@Override
	public String getResource() {
		String result = "/courses/" + courseId + "/textMultimedias/" + htmlId + "/content.html";
		return result; 
	}

	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = responseContent;
	}
	
}
