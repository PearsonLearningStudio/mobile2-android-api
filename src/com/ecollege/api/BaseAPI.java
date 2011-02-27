package com.ecollege.api;

import java.util.HashMap;

import com.ecollege.api.exceptions.ServiceException;

public class BaseAPI {

    protected SessionManager session;
    protected AbstractHttpClient httpClient;

    public BaseAPI(SessionManager session, AbstractHttpClient httpClient) {
        this.session = session;
        this.httpClient = httpClient;
    }

    public String fetchURL(String url) throws ServiceException {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("X-Authorization", "Access_Token access_token=" + session.getToken());
        String response = httpClient.get(url, headers, null);
        return response;
    }
}
