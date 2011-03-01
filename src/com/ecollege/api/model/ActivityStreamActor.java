package com.ecollege.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ActivityStreamActor implements Serializable {

	private String role;
	private long referenceId;
	private String title;
	private String objectType;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(long referenceId) {
		this.referenceId = referenceId;
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
