package com.ecollege.api.services.activities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.ActivityStreamItem;
import com.ecollege.api.services.BaseService;

public class FetchMyWhatsHappeningFeed extends BaseService {

	private Calendar since;
	
	public FetchMyWhatsHappeningFeed() {
		
	}	
	
	public FetchMyWhatsHappeningFeed(Calendar since) {
		this.since=since;
	}
	
	private List<ActivityStreamItem> result;
	
	public List<ActivityStreamItem> getResult() {
		return result;
	}

	@Override
	public String getResource() {
		String result = "/me/whatshappeningfeed"; 
		
		if (since != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			result += "?since=" + sdf.format(since.getTime());
		}
		
		return result; 
	}

	@Override
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		result = parseContentAsJsonArray(responseContent,"activityStream.items", ActivityStreamItem.class);
		System.out.println("Result is " + result);
	}
	
}
