package com.ecollege.api;

import java.util.Map;

/** 
    This class should be extended by your platform's particular implementation. 
    All eCollege apis that access the web will use your implementation so that 
    all platform specific http client issues are dealt with in an abstract way.
 */
public abstract class AbstractHttpClient {
    
    abstract public String get(String url, Map<String, String> headers, Map<String, String> params);
    abstract public String post(String url, Map<String, String> headers, Map<String, String> params);

    public String get(String url) {
        return get(url, null, null);
    }

    public String get(String url, Map<String, String> headers) {
        return get(url, headers, null);
    }

    public String post(String url) {
        return post(url, null, null);
    }

    public String post(String url, Map<String, String> headers) {
        return post(url, headers, null);
    }
 
}
