package com.ecollege.api.services.users;

import java.util.logging.Logger;

import com.ecollege.api.model.User;
import com.ecollege.api.services.BaseService;

public class FetchMeService extends BaseService {

	private static Logger l = Logger.getLogger(FetchMeService.class.getName());
	private User result;
	
	public User getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/me";
	}

	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJson(responseContent,"me", User.class);
		l.finest("Result is " + result);
	}
	
}
