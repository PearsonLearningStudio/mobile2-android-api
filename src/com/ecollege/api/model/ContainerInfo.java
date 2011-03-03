package com.ecollege.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ContainerInfo implements Serializable {
	
	private long contentItemId;
	private String contentItemTitle;
	private long contentItemOrderNumber;
	private String unitTitle;
	private long unitNumber;
	private String unitHeader;
	private long courseId;
	private String courseTitle;
	
	public long getContentItemId() {
		return contentItemId;
	}
	public void setContentItemId(long contentItemId) {
		this.contentItemId = contentItemId;
	}
	public String getContentItemTitle() {
		return contentItemTitle;
	}
	public void setContentItemTitle(String contentItemTitle) {
		this.contentItemTitle = contentItemTitle;
	}
	public long getContentItemOrderNumber() {
		return contentItemOrderNumber;
	}
	public void setContentItemOrderNumber(long contentItemOrderNumber) {
		this.contentItemOrderNumber = contentItemOrderNumber;
	}
	public String getUnitTitle() {
		return unitTitle;
	}
	public void setUnitTitle(String unitTitle) {
		this.unitTitle = unitTitle;
	}
	public long getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(long unitNumber) {
		this.unitNumber = unitNumber;
	}
	public String getUnitHeader() {
		return unitHeader;
	}
	public void setUnitHeader(String unitHeader) {
		this.unitHeader = unitHeader;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	
	
}
