package com.ecollege.api.model;

import java.io.Serializable;

/*
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
 */


@SuppressWarnings("serial")
public class DropboxAttachment implements Serializable {

	private long id;
	private String name;
	private String contentUrl;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	
}
