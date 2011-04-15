package com.ecollege.api;


public interface ECollegeHttpResponseCache {

	/**
	 * CacheEntry is an object which contains cached data and metadata about it
	 *  
	 */
	
	public class CacheEntry {
		public String data;
		public long cachedAt;
		
		public CacheEntry(String data, long cachedAt) {
			super();
			this.data = data;
			this.cachedAt = cachedAt;
		}
	}

	public CacheEntry get(String cacheScope, String cacheKey);
	public void put(String cacheScope, String cacheKey, String responseContent);
	public void invalidateCacheScope(String cacheScope);
	public void invalidateCacheKey(String cacheScope, String cacheKey);
	public Integer removeInvalidEntries();

}
