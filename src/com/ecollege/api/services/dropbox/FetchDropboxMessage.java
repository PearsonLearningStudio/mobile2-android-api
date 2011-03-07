package com.ecollege.api.services.dropbox;

import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.DropboxMessage;
import com.ecollege.api.services.BaseService;

public class FetchDropboxMessage extends BaseService {

	private static Logger l = Logger.getLogger(FetchDropboxMessage.class.getName());
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
		l.finest("Result is " + result);
	}
	
}
