package com.ecollege.api.services.discussions;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.codehaus.jackson.map.ObjectMapper;

import com.ecollege.api.services.BaseService;

public class PostResponseToTopic extends BaseService {
	
	private long topicId;
	private String title;
	private String text;
	
	public PostResponseToTopic(long topicId, String title, String text) {
		this.topicId = topicId;
		this.title = title;
		this.text = text;
	}

	@Override public Class<? extends HttpRequestBase> getRequestClass() { return HttpPost.class; }
	@Override public boolean isCacheable() { return false; }

	@Override
	public String getResource() {
		return "/me/topics/" + topicId + "/responses";
	}

	@Override
	public void prepareRequest(HttpRequestBase request, String clientString, String clientId) throws Exception {
		HttpEntityEnclosingRequestBase postRequest = (HttpEntityEnclosingRequestBase) request;
		HashMap<String, HashMap<String, String>> topicResponse = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> topicResponseBody = new HashMap<String, String>();
		topicResponseBody.put("title", title);
		topicResponseBody.put("description", text);
		topicResponse.put("response", topicResponseBody);
		ObjectMapper mapper = new ObjectMapper();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		mapper.writeValue(baos,topicResponse);
		String body = baos.toString();
		postRequest.setEntity(new StringEntity(body));
	}

	
	

}
