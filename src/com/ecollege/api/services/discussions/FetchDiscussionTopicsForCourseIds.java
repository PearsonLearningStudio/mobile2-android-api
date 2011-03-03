package com.ecollege.api.services.discussions;

import java.util.List;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.UserDiscussionTopic;
import com.ecollege.api.services.BaseService;

public class FetchDiscussionTopicsForCourseIds extends BaseService {

	private List<String> courseIds;
	
	public FetchDiscussionTopicsForCourseIds(List<String> courseIds) {
		this.courseIds = courseIds;
	}
	
	private List<UserDiscussionTopic> result;
	
	public List<UserDiscussionTopic> getResult() {
		return result;
	}

	@Override
	public String getResource() {
		//TODO: Use commons stringutils join
		String formattedCourseIds = courseIds.get(0);
		for (int i=1;i<courseIds.size();i++) formattedCourseIds += ";" + courseIds.get(i);
		return "/me/userTopics?courses=" + formattedCourseIds;
	}

	@Override
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		result = parseContentAsJsonArray(responseContent,"userTopics", UserDiscussionTopic.class);
		System.out.println("Result is " + result);
	}
	
}
