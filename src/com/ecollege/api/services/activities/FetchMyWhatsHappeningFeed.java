package com.ecollege.api.services.activities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import com.ecollege.api.model.ActivityStreamItem;
import com.ecollege.api.services.BaseService;

public class FetchMyWhatsHappeningFeed extends BaseService {

	private static Logger l = Logger.getLogger(FetchMyWhatsHappeningFeed.class.getName());
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
		
		//result += "?types=thread-topic,thread-post,grade,dropbox-submission";
        result += "?types=dropbox-submission";
        
		if (since != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			result += "&since=" + sdf.format(since.getTime());
		}
		
		return result; 
	}

	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJsonArray(responseContent,"activityStream.items", ActivityStreamItem.class);
		l.finest("Result is " + result);
	}
	
}
