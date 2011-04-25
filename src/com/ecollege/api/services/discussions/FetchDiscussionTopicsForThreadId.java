package com.ecollege.api.services.discussions;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.ecollege.api.model.UserDiscussionTopic;
import com.ecollege.api.services.BaseService;

public class FetchDiscussionTopicsForThreadId extends BaseService {

	private static Logger l = Logger.getLogger(FetchDiscussionTopicsForThreadId.class.getName());
	private long courseId;
	private long threadId;

	public FetchDiscussionTopicsForThreadId(long courseId, long threadId) {
		this.courseId = courseId;
		this.threadId = threadId;
	}
	
	private List<UserDiscussionTopic> result;
	
	public List<UserDiscussionTopic> getResult() {
		return result;
	}

	@Override
	public String getResource() {
		//TODO: Use commons stringutils join
		return "/me/userTopics?courses=" + courseId;
	}

	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		List<UserDiscussionTopic> rawResult = parseContentAsJsonArray(responseContent,"userTopics", UserDiscussionTopic.class); 

		result = new ArrayList<UserDiscussionTopic>();
		
		for (UserDiscussionTopic t : rawResult) {
			if (t.getTopic().getContainerInfo().getContentItemId() == threadId) {
				result.add(t);
			}
		}
		
		l.finest("Result is " + result);
	}
	
}
