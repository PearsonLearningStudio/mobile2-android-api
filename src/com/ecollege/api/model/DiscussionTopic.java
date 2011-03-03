package com.ecollege.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DiscussionTopic implements Serializable {

	private long id;
	private String title;
	private String description;
	private long orderNumber;
	private ContainerInfo containerInfo;
	
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
	
}
