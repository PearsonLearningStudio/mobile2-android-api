package com.ecollege.api.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("serial")
public class Token implements Serializable {
	
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("expires_in")
	private int expiresIn;
	@JsonProperty("refresh_token")
	private String refreshToken;
	private Calendar createdOn;
	
	public Token()
	{
		createdOn = new GregorianCalendar();
	}
	
	public boolean isExpired() {
		GregorianCalendar expiresAt = (GregorianCalendar)createdOn.clone();
		expiresAt.add(Calendar.SECOND, expiresIn);
		GregorianCalendar now = new GregorianCalendar();
		if (expiresAt.compareTo(now) < 0) { //expiresAt < now
			return true;
		}
		return false;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Calendar getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	
}
