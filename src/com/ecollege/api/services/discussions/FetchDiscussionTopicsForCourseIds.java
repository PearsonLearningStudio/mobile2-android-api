package com.ecollege.api.services.discussions;

import java.util.List;
import java.util.logging.Logger;

import com.ecollege.api.model.UserDiscussionTopic;
import com.ecollege.api.services.BaseService;

public class FetchDiscussionTopicsForCourseIds extends BaseService {

	private static Logger l = Logger.getLogger(FetchDiscussionTopicsForCourseIds.class.getName());
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
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJsonArray(responseContent,"userTopics", UserDiscussionTopic.class);
		l.finest("Result is " + result);
	}
	
}
