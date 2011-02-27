package com.ecollege.api.services.users;

import java.util.List;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.User;
import com.ecollege.api.services.BaseService;

public class FetchUserByIdService extends BaseService {

	private long userId;
	private User result;
	
	public FetchUserByIdService(long userId) {
		this.userId = userId;
	}
	
	public User getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/users/" + userId;
	}

	@Override
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		List<User> rawResult = parseContentAsJsonArray(responseContent,"users", User.class);
		if (rawResult.size() > 0) result = rawResult.get(0);
		System.out.println("Result is " + result);
	}
	
}
