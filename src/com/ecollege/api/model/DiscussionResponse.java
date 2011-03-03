package com.ecollege.api.model;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class DiscussionResponse implements Serializable {

	private long id;
	private String title;
	private String description;
	private User author;
	private Calendar postedDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Calendar getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(Calendar postedDate) {
		this.postedDate = postedDate;
	}
	
	
}
