package com.ecollege.api.services;

import java.util.logging.Logger;

import com.ecollege.api.model.Token;

public class FetchTokenService extends BaseService {

	private static Logger l = Logger.getLogger(FetchTokenService.class.getName());
	private String grantToken;
	private Token result;
	
	public FetchTokenService(String grantToken)
	{
		this.grantToken = grantToken;
	}
	
	public Token getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/authorize/token?access_grant=" + encode(grantToken);
	}
	
	@Override
	public boolean isAuthenticationRequired() {
		return false;
	}

	@Override
	public boolean isCacheable() {
		return false;
	}
	
	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJson(responseContent, Token.class);
		l.finest("Result is " + result);
	}
	
}
