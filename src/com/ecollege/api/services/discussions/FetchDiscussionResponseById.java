package com.ecollege.api.services.discussions;

import java.util.List;
import java.util.logging.Logger;

import com.ecollege.api.model.UserDiscussionResponse;
import com.ecollege.api.services.BaseService;

public class FetchDiscussionResponseById extends BaseService {

	private static Logger l = Logger.getLogger(FetchDiscussionResponseById.class.getName());
	private String userResponseId;

	public FetchDiscussionResponseById(long userId, long responseId) {
		this.userResponseId = userId + "-" + responseId;
	}
	
	public FetchDiscussionResponseById(String userResponseId) {
		this.userResponseId = userResponseId;
	}
	
	private UserDiscussionResponse result;
	
	public UserDiscussionResponse getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/me/userresponses/" + userResponseId;
	}

	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		List<UserDiscussionResponse> rawResult = parseContentAsJsonArray(responseContent,"userResponses", UserDiscussionResponse.class);
		result = rawResult.get(0);
		l.finest("Result is " + result);
	}
	
}
