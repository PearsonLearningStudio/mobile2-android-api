package com.ecollege.api;

import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;

import com.ecollege.api.exceptions.DeserializationException;
import com.ecollege.api.exceptions.ServiceException;
import com.ecollege.api.exceptions.TimeoutException;
import com.ecollege.api.model.Token;
import com.ecollege.api.services.BaseService;
import com.ecollege.api.services.FetchGrantService;
import com.ecollege.api.services.FetchTokenService;

public class ECollegeClient {

	private static Logger l = Logger.getLogger(ECollegeClient.class.getName());
	public static final String ROOT_URI = "https://m-api.ecollege.com";
	
	private String clientString;
	private String clientId;
	private String username;
	private String password;
	private String grantToken;
	private Token token;
	private String userAgent = "eCollege Java API";
	private ResponseHandler<ECollegeHttpResponse> responseHandler = new ECollegeHttpResponseHandler();
	
	public String getGrantToken() {
		return grantToken;
	}

	public ECollegeClient(String clientString, String clientId)
	{
		this.clientString = clientString;
		this.clientId = clientId;
	}
	
	public void setupAuthentication(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setupAuthentication(String grantToken) {
		this.grantToken = grantToken;
	}
	
	public void executeService(BaseService service) throws Exception {
		executeService(service,null);
	}
	
	public void executeService(BaseService service, ECollegeHttpResponseCache cache) throws Exception {		
		String cacheKey = null;
		String responseContent = null;
		
		HttpClient httpclient = new DefaultHttpClient();
		
		HttpProtocolParams.setUserAgent(httpclient.getParams(), userAgent);
		HttpProtocolParams.setContentCharset(httpclient.getParams(), "UTF-8");
		HttpProtocolParams.setHttpElementCharset(httpclient.getParams(), "UTF-8");	
		
		HttpRequestBase request = service.getRequestClass().newInstance(); //HttpGet, HttpPost, etc
		request.addHeader("Accept-Encoding", "gzip");
		
		if (service.isAuthenticationRequired()) {
			prepareAuthenticationHeaders(request);
		}
		
		if (cache != null && service.isCacheable()) {
			cacheKey = service.getCacheKey(grantToken == null ? "" : grantToken);
			responseContent = cache.get(cacheKey);
		}			

		if (responseContent == null) {
			
			String url = ROOT_URI + service.getResource();
			request.setURI(new URI(url));		
			l.info("Request is: " + url);
			service.prepareRequest(request,clientString,clientId);
			
			ECollegeHttpResponse response = null;
			
			try {
				response = httpclient.execute(request,responseHandler);
			} catch (SocketException se) {
				l.log(Level.WARNING,"socket exception", se);
				// TODO it seems to be the case that timeouts always
				// end up as a socket instead of socket timeout exception.
				// Research this
				throw new TimeoutException(se);
			} catch (SocketTimeoutException stoe) {
				l.log(Level.WARNING,"socket timeout exception", stoe);
				throw new TimeoutException(stoe);			
			} catch (IOException e) {
				l.log(Level.WARNING,"unhandled io exception", e);
				throw new ServiceException(e);
			}
			
			responseContent = response.getResponseContent();
			if (cache != null && service.isCacheable()) {
				cache.put(cacheKey, responseContent);
			}
		}
		
		try {
			service.processResponse(responseContent);
		} catch (Exception e) {
			throw new DeserializationException(e);
		}
	}
	
	protected void prepareAuthenticationHeaders(HttpRequestBase request) throws Exception {
		if (grantToken == null && username != null && password != null) {
			FetchGrantService fgs = new FetchGrantService(username, password);				
			executeService(fgs);
			grantToken = fgs.getResult().getAccessToken();
			username = null; //no need to store now
			password = null;
		}
		
		if (grantToken == null) {
			throw new RuntimeException("Authentication required but no credentials available");
		}
		
		if (token == null || token.isExpired()) {
			FetchTokenService fts = new FetchTokenService(grantToken);
			executeService(fts);
			token = fts.getResult();
		}
		
		request.addHeader("X-Authorization", "Access_Token access_token=" + token.getAccessToken());
	}
}
