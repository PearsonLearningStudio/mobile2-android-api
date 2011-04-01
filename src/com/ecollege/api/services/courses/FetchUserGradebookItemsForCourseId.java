package com.ecollege.api.services.courses;

import java.util.List;

import com.ecollege.api.model.UserGradebookItem;
import com.ecollege.api.services.BaseService;

public class FetchUserGradebookItemsForCourseId extends BaseService {

	private long courseId;
	private boolean includeGrades;
	private List<UserGradebookItem> result;

	public FetchUserGradebookItemsForCourseId(long courseId, boolean includeGrades) {
		this.courseId = courseId;
		this.includeGrades = includeGrades;
	}

	@Override
	public String getResource() {
		String resource = "/me/courses/" + courseId + "/userGradebookItems";
		if (includeGrades) {
			resource = resource + "?expand=grade";
		}
		return resource;
	}

	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJsonArray(responseContent, "userGradebookItems", UserGradebookItem.class);
	}

	public List<UserGradebookItem> getResult() {
		return result;
	}

}
