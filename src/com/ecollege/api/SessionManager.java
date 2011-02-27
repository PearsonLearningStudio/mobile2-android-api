package com.ecollege.api;

import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.ecollege.api.exceptions.DeserializationException;
import com.ecollege.api.exceptions.ServiceException;

public class SessionManager {

    private String clientId;
    private String clientString;
    private String username;
    private String password;
    private String token;

    private AbstractHttpClient httpClient;

    public SessionManager(String clientId, String clientString, String username, String password, AbstractHttpClient httpClient) {
        this.clientId = clientId;
        this.clientString = clientString;
        this.username = username;
        this.password = password;
        this.httpClient = httpClient;
    }

    public String getToken() {
        return token;
    }

    public Boolean hasToken() {
        return (token != null);
    }
  
    public void reset() {
        clientId = clientString = username = password = token = null;
    }

    public void authenticate() throws ServiceException {
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("grant_type", "password");
            params.put("username", clientString + "\\" + username);
            params.put("password", password);
            params.put("client_id", clientId);

            String response = httpClient.post("https://m-api.ecollege.com/token", null, params);
            HashMap<String, Object> tokenObject = new ObjectMapper().readValue(response, new TypeReference<HashMap<String, Object>>() { });
            if (tokenObject.containsKey("error")) {
                
            } else {
                token = (String)tokenObject.get("access_token");
            }
        } catch (IOException ioe) {
            throw new DeserializationException("Unable to deserialize token" + ioe);
        } catch (Exception e) {
            throw new ServiceException("Unable to authenticate: " + e);
        }

    }

}
