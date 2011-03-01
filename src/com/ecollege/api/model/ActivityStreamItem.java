package com.ecollege.api.model;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class ActivityStreamItem implements Serializable {

	private String id;
	private Calendar postedTime;
	private ActivityStreamActor actor;
	private String verb;
	private ActivityStreamObject object;
	private ActivityStreamTarget target;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Calendar getPostedTime() {
		return postedTime;
	}
	public void setPostedTime(Calendar postedTime) {
		this.postedTime = postedTime;
	}
	public ActivityStreamActor getActor() {
		return actor;
	}
	public void setActor(ActivityStreamActor actor) {
		this.actor = actor;
	}
	public String getVerb() {
		return verb;
	}
	public void setVerb(String verb) {
		this.verb = verb;
	}
	public ActivityStreamObject getObject() {
		return object;
	}
	public void setObject(ActivityStreamObject object) {
		this.object = object;
	}
	public ActivityStreamTarget getTarget() {
		return target;
	}
	public void setTarget(ActivityStreamTarget target) {
		this.target = target;
	}
	
}
