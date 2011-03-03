package com.ecollege.api.services.dropbox;

import java.util.List;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.DropboxMessage;
import com.ecollege.api.services.BaseService;

public class FetchDropboxMessage extends BaseService {

	private long courseId;
	private long basketId;
	private long messageId;

	public FetchDropboxMessage(long courseId, long basketId, long messageId) {
		this.courseId = courseId;
		this.basketId = basketId;
		this.messageId = messageId;
	}
	
	private DropboxMessage result;
	
	public DropboxMessage getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/courses/" + courseId + "/dropboxBaskets/" + basketId + "/messages/" + messageId;
	}

	@Override
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		List<DropboxMessage> rawResult = parseContentAsJsonArray(responseContent,"messages", DropboxMessage.class);
		result = rawResult.get(0);
		System.out.println("Result is " + result);
	}
	
}
