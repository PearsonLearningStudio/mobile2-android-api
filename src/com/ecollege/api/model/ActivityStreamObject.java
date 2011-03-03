package com.ecollege.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class ActivityStreamObject implements Serializable {

	private long courseId;
	private String referenceId;
	private String id;
	private String summary;
	private String objectType;
	private String letterGrade; //on grades
	private BigDecimal pointsAchieved; //on grades
	
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public String getLetterGrade() {
		return letterGrade;
	}
	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}
	public BigDecimal getPointsAchieved() {
		return pointsAchieved;
	}
	public void setPointsAchieved(BigDecimal pointsAchieved) {
		this.pointsAchieved = pointsAchieved;
	}
	
}
