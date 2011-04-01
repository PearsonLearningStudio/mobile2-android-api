package com.ecollege.api.services.discussions;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.codehaus.jackson.map.ObjectMapper;

import com.ecollege.api.services.BaseService;

public class UpdateResponseReadStatus extends BaseService {
	
	private long responseId;
	private Boolean markAsRead;
	
	public UpdateResponseReadStatus(long responseId, Boolean markAsRead) {
		this.responseId = responseId;
		this.markAsRead = markAsRead;
	}
	
	@Override public Class<? extends HttpRequestBase> getRequestClass() { return HttpPost.class; }
	@Override public boolean isCacheable() { return false; }

	@Override public String getResource() {
		return "/me/responses/" + responseId + "/readStatus";
	}

	@Override public void prepareRequest(HttpRequestBase request, String clientString, String clientId) throws Exception {
		HttpEntityEnclosingRequestBase postRequest = (HttpEntityEnclosingRequestBase) request;
		HashMap<String, HashMap<String, Boolean>> response = new HashMap<String, HashMap<String, Boolean>>();
		HashMap<String, Boolean> responseContent = new HashMap<String, Boolean>();
		responseContent.put("markedAsRead", markAsRead);
		response.put("readStatus", responseContent);
		ObjectMapper mapper = new ObjectMapper();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		mapper.writeValue(baos,response);
		String body = baos.toString();
		postRequest.setEntity(new StringEntity(body));
	}	

}
