package com.ecollege.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

/*
{
    "grade":{
        "id":18287,
        "points":10.00,
        "letterGrade":"A",
        "comments":"test grade comment text",
        "updatedDate":"2010-09-09T16:22:41Z",
        "gradedStudent":{
            "id":2115865,
            "links":[{
                "href":"http://m-api.ecollege-labs.com/users/2115865",
                "rel":"self"
            }]
        }
    }
}
 */


@SuppressWarnings("serial")
public class Grade implements Serializable {

	private long id;
	private BigDecimal points;
	private String letterGrade;
	private String comments;
	private Calendar updatedDate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getPoints() {
		return points;
	}
	public void setPoints(BigDecimal points) {
		this.points = points;
	}
	public String getLetterGrade() {
		return letterGrade;
	}
	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Calendar getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
