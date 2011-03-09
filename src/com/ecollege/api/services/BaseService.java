package com.ecollege.api.services;

import static org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES;

import java.io.Serializable;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;

public abstract class BaseService {
	
	// begin settings
	public Class<? extends HttpRequestBase> getRequestClass() {
		return HttpGet.class;
	}
	
	public abstract String getResource();	
	
	public boolean isAuthenticationRequired() {
		return true;
	}
	
	public boolean isCacheable() {
		return true;
	}
	
	private static final String CACHE_VERSION = "0"; //change to invalidate existing caches
	
	public String getCacheKey() {
		MessageDigest digest;
		try {
			digest = java.security.MessageDigest.getInstance("MD5");
			digest.update(getResource().getBytes());
			digest.update(getRequestClass().getSimpleName().getBytes());
			digest.update(CACHE_VERSION.getBytes());
			return new BigInteger(1,digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	// end settings
	
	
	public void prepareRequest(HttpRequestBase request, String clientString, String clientId) throws Exception
	{
		//override in subclass if needed
	}
	
	protected void setParameters(HttpEntityEnclosingRequestBase request, Map<String, String> parameterMap) throws Exception {
		ArrayList<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (null == parameterMap) {
			return;
		}
		String value;
		for (String key : parameterMap.keySet()) {
			value = parameterMap.get(key);
			nvps.add(new BasicNameValuePair(key, value));
		}
		request.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
	}

	public void processResponse(String responseContent) {
		//override in subclass
	}
	
	protected <T extends Serializable> T parseContentAsJson(String json, Class<T> responseType) {
		return parseContentAsJson(json,null, responseType);
	}
	
	protected <T extends Serializable> T parseContentAsJson(String json, String path, Class<T> responseType) {
		try {
	        ObjectMapper mapper = createMapper();
			JsonNode rootNode = findRootNode(json,path);
            return mapper.treeToValue(rootNode, responseType);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	private static ObjectMapper mapper;
	private ObjectMapper createMapper() {
		if (mapper == null) {
	        mapper = new ObjectMapper();
	        mapper.getDeserializationConfig().set(
	                FAIL_ON_UNKNOWN_PROPERTIES,
	                false
	                );
		}
        return mapper;
	}
	
	private JsonNode findRootNode(String json, String path) {
		try {
	        ObjectMapper mapper = createMapper();
	        JsonNode rootNode = mapper.readValue(json, JsonNode.class);
	        
	        if (path != null) {
	        	
	        	if (path.contains(".")) {
		        	String pathParts[] = path.split("\\.");
		        	for (String pathPart : pathParts) {
		        		rootNode = rootNode.get(pathPart);
		        	}
	        	} else {
	        		rootNode = rootNode.get(path);
	        	}
	        }
	        
	        return rootNode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected <T extends Serializable> List<T> parseContentAsJsonArray(String json, Class<T> responseType) {
		return parseContentAsJsonArray(json, null, responseType);
	}
	
	protected <T extends Serializable> List<T> parseContentAsJsonArray(String json, String path, Class<T> responseType) {
		try {
			List<T> result = new ArrayList<T>();
	        ObjectMapper mapper = createMapper();
			ArrayNode rootNode = (ArrayNode) findRootNode(json,path);
			
            Iterator<JsonNode> courseObjectIterator = rootNode.getElements();

            while (courseObjectIterator.hasNext()) {
                JsonNode childNode = courseObjectIterator.next();
                result.add(mapper.treeToValue(childNode, responseType));
            }
            return result;
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected String encode(String toEncode) {
		try {
			return URLEncoder.encode(toEncode,"UTF-8");
		} catch (Throwable t) {}
		return "";
	}
	
}
