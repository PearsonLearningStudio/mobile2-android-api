package com.ecollege.api.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/*
{
    "messages":[
        {
            "id":122333,
            "date":"2010-02-11T17:03:34.18Z",
            "comments":"This is a comment.",
            "submissionStudent":{
                "id":111234,
                "firstName":"Jim",
                "lastName":"Smith",
                "email":"jim.smith@school.edu",
                "links":[
                    {
                        "href":"http://m-api.ecollege.com/users/111234",
                        "rel":"self"
                    }
                ]
            }
            "author":{
                "id":412132,
                "firstName":"Dr. Daniel",
                "lastName":"Stewart",
                "email":"daniel.stewart@school.edu",
                "links":[
                    {
                        "href":"http://m-api.ecollege.com/users/412132",
                        "rel":"self"
                    }
                ]
            },
            "attachments":[
                {
                    "id":{attachmentId},
                    "name":{attachmentFileName},
                    "contentUrl":"http://m-api.ecollege.com/courses/{courseId}/dropboxBaskets/{basketId}/messages/{messageId}/attachments/{attachmentId}/content"
                    "links":[
                        {
                            "href":"http://m-api.ecollege.com/courses/{courseId}/dropboxBaskets/{basketId}/messages/{messageId}/attachments/{attachmentId}",
                            "rel":"self"
                        }
                    ]
                }
            ]
        }
    ]
}
 */


@SuppressWarnings("serial")
public class DropboxMessage implements Serializable {

	private long id;
	private Calendar date;
	private String comments;
	private User submissionStudent;
	private User author;
	private List<DropboxAttachment> attachments;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public User getSubmissionStudent() {
		return submissionStudent;
	}
	public void setSubmissionStudent(User submissionStudent) {
		this.submissionStudent = submissionStudent;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public List<DropboxAttachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<DropboxAttachment> attachments) {
		this.attachments = attachments;
	}
	
}
