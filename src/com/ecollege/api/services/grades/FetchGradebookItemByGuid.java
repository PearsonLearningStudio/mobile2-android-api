package com.ecollege.api.services.grades;

import java.util.List;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.GradebookItem;
import com.ecollege.api.services.BaseService;

public class FetchGradebookItemByGuid extends BaseService {

	private long courseId;
	private String gradebookItemGuid;

	public FetchGradebookItemByGuid(long courseId, String gradebookItemGuid) {
		this.courseId = courseId;
		this.gradebookItemGuid = gradebookItemGuid;
	}
	
	private GradebookItem result;
	
	public GradebookItem getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/courses/" + courseId + "/gradebookItems/" + gradebookItemGuid;
	}

	@Override
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		List<GradebookItem> rawResult = parseContentAsJsonArray(responseContent,"gradebookItems", GradebookItem.class);
		result = rawResult.get(0);
		System.out.println("Result is " + result);
	}
	
}
