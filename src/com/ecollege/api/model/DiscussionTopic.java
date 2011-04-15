package com.ecollege.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DiscussionTopic implements Serializable {

	private long id;
	private String title;
	private String description;
	private long orderNumber;
	private ContainerInfo containerInfo;
	private String rawDescription;
	
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
		rawDescription = null;
	}
	public long getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}
	public ContainerInfo getContainerInfo() {
		return containerInfo;
	}
	public void setContainerInfo(ContainerInfo containerInfo) {
		this.containerInfo = containerInfo;
	}
	public String getRawDescription() {
		// memoize to avoid extra processing
		if (rawDescription == null) {
			// remove tags (naively for now) and beginning and ending whitespace
			rawDescription = description.replaceAll("<[^>]+>", "").replaceAll("&nbsp;", "").trim();
		}
		return rawDescription;
	}
	
}
