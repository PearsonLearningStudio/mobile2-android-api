package com.ecollege.api.services.upcoming;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import com.ecollege.api.model.UpcomingEventItem;
import com.ecollege.api.services.BaseService;

public class FetchMyUpcomingEventsService extends BaseService {

	private static Logger l = Logger.getLogger(FetchMyUpcomingEventsService.class.getName());
	private Calendar until;
	
	public FetchMyUpcomingEventsService() {
		
	}	
	
	public FetchMyUpcomingEventsService(Calendar until) {
		this.until=until;
	}
	
	private List<UpcomingEventItem> result;
	
	public List<UpcomingEventItem> getResult() {
		return result;
	}

	@Override
	public String getResource() {
		String result = "/me/upcomingevents"; 
		
		if (until != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			result += "?until=" + sdf.format(until.getTime());
		}
		
		return result; 
	}

	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJsonArray(responseContent,"upcomingEvents", UpcomingEventItem.class);
		l.finest("Result is " + result);
	}
	
}
