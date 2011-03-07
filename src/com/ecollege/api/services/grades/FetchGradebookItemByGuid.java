package com.ecollege.api.services.grades;

import java.util.List;
import java.util.logging.Logger;

import com.ecollege.api.model.GradebookItem;
import com.ecollege.api.services.BaseService;

public class FetchGradebookItemByGuid extends BaseService {

	private static Logger l = Logger.getLogger(FetchGradebookItemByGuid.class.getName());
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
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		List<GradebookItem> rawResult = parseContentAsJsonArray(responseContent,"gradebookItems", GradebookItem.class);
		result = rawResult.get(0);
		l.finest("Result is " + result);
	}
	
}
