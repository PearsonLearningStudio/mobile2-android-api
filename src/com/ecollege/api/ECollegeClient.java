package com.ecollege.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

import com.ecollege.api.model.GrantToken;
import com.ecollege.api.model.Token;
import com.ecollege.api.services.BaseService;
import com.ecollege.api.services.FetchGrantService;
import com.ecollege.api.services.FetchTokenService;

public class ECollegeClient {

	public static final String ROOT_URI = "https://m-api.ecollege.com";
	
	private String clientString;
	private String clientId;
	private String username;
	private String password;
	private GrantToken grantToken;
	private Token token;
	
	public ECollegeClient(String clientString, String clientId)
	{
		this.clientString = clientString;
		this.clientId = clientId;
	}
	
	public void setupAuthentication(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setupAuthentication(GrantToken grantToken) {
		this.grantToken = grantToken;
	}
	
	public void executeService(BaseService service) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		HttpRequestBase request = service.getRequestClass().newInstance(); //HttpGet, HttpPost, etc
		
		if (service.isAuthenticationRequired()) {
			
			if (grantToken == null && username != null && password != null) {
				FetchGrantService fgs = new FetchGrantService(username, password);				
				executeService(fgs);
				grantToken = fgs.getResult();
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
		
		String url = ROOT_URI + service.getResource();
		request.setURI(new URI(url));		
		System.out.println("Request is: " + url);
		service.prepareRequest(request,clientString,clientId);

		HttpResponse response = httpclient.execute(request);
		String responseContent = parseResponseContent(response);
		System.out.println("Response Status is: " + response.getStatusLine());
		System.out.println("Response Content is:\n " + responseContent);
		service.processResponse(response,responseContent);
	}
	
	private String parseResponseContent(HttpResponse response) {
		String result = "";
		try {
			result = convertStreamToString(response.getEntity().getContent());
		} catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
    private String convertStreamToString(InputStream is) {    	
    	
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
