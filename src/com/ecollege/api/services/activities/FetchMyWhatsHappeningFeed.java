package com.ecollege.api.services.activities;

import java.util.List;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.ActivityStreamItem;
import com.ecollege.api.services.BaseService;

public class FetchMyWhatsHappeningFeed extends BaseService {

	private List<ActivityStreamItem> result;
	
	public List<ActivityStreamItem> getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/me/whatshappeningfeed";
	}

	@Override
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		result = parseContentAsJsonArray(responseContent,"activityStream.items", ActivityStreamItem.class);
		System.out.println("Result is " + result);
	}
	
}
