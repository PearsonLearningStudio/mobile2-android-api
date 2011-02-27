package com.ecollege.api.services;

import org.apache.http.HttpResponse;

import com.ecollege.api.model.GrantToken;
import com.ecollege.api.model.Token;

public class FetchTokenService extends BaseService {

	private GrantToken grantToken;
	private Token result;
	
	public FetchTokenService(GrantToken grantToken)
	{
		this.grantToken = grantToken;
	}
	
	public Token getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/authorize/token?access_grant=" + encode(grantToken.getAccessToken());
	}
	
	@Override
	public boolean isAuthenticationRequired() {
		return false;
	}

	@Override
	public void processResponse(HttpResponse response, String responseContent) {
		super.processResponse(response,responseContent);
		result = parseContentAsJson(responseContent, Token.class);
		System.out.println("Result is " + result);
	}
	
}
