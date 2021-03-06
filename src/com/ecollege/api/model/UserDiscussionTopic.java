package com.ecollege.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserDiscussionTopic implements Serializable {

	private String id;
	private DiscussionTopic topic;
	private ResponseCount childResponseCounts;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DiscussionTopic getTopic() {
		return topic;
	}
	public void setTopic(DiscussionTopic topic) {
		this.topic = topic;
	}
	public ResponseCount getChildResponseCounts() {
		return childResponseCounts;
	}
	public void setChildResponseCounts(ResponseCount childResponseCounts) {
		this.childResponseCounts = childResponseCounts;
	}

	public boolean isActive() {
		ResponseCount rc = getChildResponseCounts();
		if (rc != null) {
			if (rc.getLast24HourResponseCount() > 0 || rc.getUnreadResponseCount() > 0) {
				return true;
			}
		}
		return false;
	}
}
