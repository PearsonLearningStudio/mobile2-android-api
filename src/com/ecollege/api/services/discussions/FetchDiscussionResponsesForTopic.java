package com.ecollege.api.services.discussions;

import java.util.List;
import java.util.logging.Logger;

import com.ecollege.api.model.DiscussionTopic;
import com.ecollege.api.model.UserDiscussionResponse;
import com.ecollege.api.model.UserDiscussionTopic;
import com.ecollege.api.services.BaseService;

public class FetchDiscussionResponsesForTopic extends BaseService {
	
	private static Logger l = Logger.getLogger(FetchDiscussionResponsesForTopic.class.getName());
	private UserDiscussionTopic topic;
	private List<UserDiscussionResponse> result;
	
	public List<UserDiscussionResponse> getResult() {
		return result;
	}

	public FetchDiscussionResponsesForTopic(UserDiscussionTopic topic) {
		super();
		this.topic = topic;
	}

	@Override
	public String getResource() {
		DiscussionTopic dt = topic.getTopic();
		return "/me/topics/" + dt.getId() + "/userresponses";
	}
	
	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJsonArray(responseContent, "userResponses", UserDiscussionResponse.class);
		l.finest("Result is " + result);
	}

}
