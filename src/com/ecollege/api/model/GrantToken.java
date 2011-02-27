package com.ecollege.api.model;

import java.io.Serializable;
import java.util.Calendar;

import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("serial")
public class GrantToken implements Serializable {
	
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("expires_in")
	private Calendar expiresIn;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Calendar getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Calendar expiresIn) {
		this.expiresIn = expiresIn;
	}
	
}
