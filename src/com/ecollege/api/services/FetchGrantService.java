package com.ecollege.api.services;

import java.util.HashMap;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;

import com.ecollege.api.model.GrantToken;

public class FetchGrantService extends BaseService {

	private static Logger l = Logger.getLogger(FetchGrantService.class.getName());
	private String username;
	private String password;
	
	private GrantToken result;
	
	public GrantToken getResult() {
		return result;
	}

	public FetchGrantService(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	@Override
	public Class<? extends HttpRequestBase> getRequestClass() {
		return HttpPost.class;
	}

	@Override
	public String getResource() {
		return "/authorize/grant";
	}
	@Override
	public boolean isAuthenticationRequired() {
		return false;
	}

	@Override
	public void prepareRequest(HttpRequestBase request, String clientString,
			String clientId) throws Exception {
		
		HttpPost postRequest = (HttpPost)request;

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("clientString", clientString);
        params.put("client_id", clientId);
        params.put("userLogin", username);
        params.put("password",password);
        
        setParameters(postRequest, params);
	}


	@Override
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		result = parseContentAsJson(responseContent, GrantToken.class);
		l.finest("Result is " + result);
	}
	
	
	
}
