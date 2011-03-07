package com.ecollege.api.services.grades;

import java.util.logging.Logger;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.Grade;
import com.ecollege.api.services.BaseService;

public class FetchMyGradebookItemGrade extends BaseService {

	private static Logger l = Logger.getLogger(FetchMyGradebookItemGrade.class.getName());
	private long courseId;
	private String gradebookItemGuid;

	public FetchMyGradebookItemGrade(long courseId, String gradebookItemGuid) {
		this.courseId = courseId;
		this.gradebookItemGuid = gradebookItemGuid;
	}
	
	private Grade result;
	
	public Grade getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/me/courses/" + courseId + "/gradebookItems/" + gradebookItemGuid + "/grade";
	}

	@Override
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		result = parseContentAsJson(responseContent,"grade", Grade.class);
		l.finest("Result is " + result);
	}
	
}
