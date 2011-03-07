package com.ecollege.api.services.discussions;

import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.UserDiscussionTopic;
import com.ecollege.api.services.BaseService;

public class FetchDiscussionTopicById extends BaseService {

	private static Logger l = Logger.getLogger(FetchDiscussionTopicById.class.getName());
	private String userTopicId;
	

	public FetchDiscussionTopicById(long userId, long topicId) {
		this.userTopicId = userId + "-" + topicId;
	}
	
	public FetchDiscussionTopicById(String userTopicId) {
		this.userTopicId = userTopicId;
	}
	
	private UserDiscussionTopic result;
	
	public UserDiscussionTopic getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/me/usertopics/" + userTopicId;
	}

	@Override
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		List<UserDiscussionTopic> rawResult = parseContentAsJsonArray(responseContent,"userTopics", UserDiscussionTopic.class);
		result = rawResult.get(0);
		l.finest("Result is " + result);
	}
	
}
