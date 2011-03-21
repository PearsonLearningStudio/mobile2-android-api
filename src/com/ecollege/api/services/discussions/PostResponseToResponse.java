package com.ecollege.api.services.discussions;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.codehaus.jackson.map.ObjectMapper;

import com.ecollege.api.services.BaseService;

public class PostResponseToResponse extends BaseService {
	
	private long responseId;
	private String title;
	private String text;
	
	public PostResponseToResponse(long responseId, String title, String text) {
		this.responseId = responseId;
		this.title = title;
		this.text = text;
	}

	@Override public Class<? extends HttpRequestBase> getRequestClass() { return HttpPost.class; }
	@Override public boolean isCacheable() { return false; }

	@Override
	public String getResource() {
		return "/me/responses/" + responseId + "/responses";
	}

	@Override
	public void prepareRequest(HttpRequestBase request, String clientString, String clientId) throws Exception {
		HttpEntityEnclosingRequestBase postRequest = (HttpEntityEnclosingRequestBase) request;
		HashMap<String, HashMap<String, String>> response = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> responseContent = new HashMap<String, String>();
		responseContent.put("title", title);
		responseContent.put("description", text);
		response.put("response", responseContent);
		ObjectMapper mapper = new ObjectMapper();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		mapper.writeValue(baos,response);
		String body = baos.toString();
		postRequest.setEntity(new StringEntity(body));
	}

	
	

}
