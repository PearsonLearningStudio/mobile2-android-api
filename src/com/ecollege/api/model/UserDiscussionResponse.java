package com.ecollege.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserDiscussionResponse implements Serializable {

	private String id;
	private boolean markedAsRead;
	private DiscussionResponse response;
	private ResponseCount childResponseCounts;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isMarkedAsRead() {
		return markedAsRead;
	}
	public void setMarkedAsRead(boolean markedAsRead) {
		this.markedAsRead = markedAsRead;
	}
	public DiscussionResponse getResponse() {
		return response;
	}
	public void setResponse(DiscussionResponse response) {
		this.response = response;
	}
	public ResponseCount getChildResponseCounts() {
		return childResponseCounts;
	}
	public void setChildResponseCounts(ResponseCount childResponseCounts) {
		this.childResponseCounts = childResponseCounts;
	}
	
}
