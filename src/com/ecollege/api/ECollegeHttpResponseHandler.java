package com.ecollege.api;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import com.ecollege.api.exceptions.BadRequestException;
import com.ecollege.api.exceptions.IncorrectCredentialsException;
import com.ecollege.api.exceptions.NotFoundException;
import com.ecollege.api.exceptions.ServiceException;
import com.ecollege.api.exceptions.UnauthorizedException;
import com.ecollege.api.exceptions.ValidationException;

public class ECollegeHttpResponseHandler implements ResponseHandler<ECollegeHttpResponse> {

	private static Logger l = Logger.getLogger(ECollegeHttpResponseHandler.class.getName());
	
	@Override
	public ECollegeHttpResponse handleResponse(HttpResponse response) throws ClientProtocolException,
			IOException {

		ECollegeHttpResponse r = new ECollegeHttpResponse();
		r.setResponse(response);
		
		HttpEntity e = response.getEntity();
		if (e != null) {
			r.setResponseContent(EntityUtils.toString(e));
		}
		
		StatusLine statusLine = response.getStatusLine();
		int statusCode = statusLine.getStatusCode();
		
		l.info("Result: " + statusLine.toString());
		
		if (statusCode < 300) { 
			l.finest("Result Content: \n" + r.getResponseContent());
			return r;
		} else {
			if (statusCode == 422) {
				l.finest("Result Content: \n" + r.getResponseContent());
				throw new ValidationException(r);
			} else if (statusCode == 401) {
				l.finest("Result Content: \n" + r.getResponseContent());
				throw new UnauthorizedException(r);
			} else if (statusCode == 404) {
				l.finest("Result Content: \n" + r.getResponseContent());
				throw new NotFoundException(r);
			} else if (statusCode == 400) {
				l.finest("Result Content: \n" + r.getResponseContent());
				
				if (r.getResponseContent() != null && r.getResponseContent().contains("incorrect_client_credentials")) { 
					throw new IncorrectCredentialsException(r);
				} else {
					throw new BadRequestException(r);	
				}
			} else {
				l.warning("Result Content: \n" + r.getResponseContent());
				throw new ServiceException(r);
			}
		}

	}

}
