package com.ecollege.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ActivityStreamTarget implements Serializable {
	
	private Object referenceId;
	private String id;
	private String title;
	private String objectType;
	
	public Object getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(Object referenceId) {
		this.referenceId = referenceId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

}
