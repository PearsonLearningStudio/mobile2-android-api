package com.ecollege.api;


public interface ECollegeHttpResponseCache {

	public String get(String cacheKey);
	public void put(String cacheKey, String responseContent);

}
