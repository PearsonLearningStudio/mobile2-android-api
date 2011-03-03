package com.ecollege.api.services.discussions;

import java.util.List;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.UserDiscussionResponse;
import com.ecollege.api.services.BaseService;

public class FetchDiscussionResponseById extends BaseService {

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
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		List<UserDiscussionResponse> rawResult = parseContentAsJsonArray(responseContent,"userResponses", UserDiscussionResponse.class);
		result = rawResult.get(0);
		System.out.println("Result is " + result);
	}
	
}
