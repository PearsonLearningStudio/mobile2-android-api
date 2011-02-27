package com.ecollege.api;


import org.junit.Before;
import org.junit.Test;

import com.ecollege.api.services.FetchGrantService;
import com.ecollege.api.services.FetchTokenService;
import com.ecollege.api.services.users.FetchMeService;

import static org.junit.Assert.*;

public class LoginTest extends BaseTest {

	protected ECollegeClient client;
	
	@Before
	public void setUp() throws Exception {
		client = new ECollegeClient(clientString, clientId);
	}
	
	@Test
	public void testFetchGrant() throws Exception
	{
		FetchGrantService fg = new FetchGrantService(sampleUsername, samplePassword);
		client.executeService(fg);
	}
	
	@Test
	public void testFetchToken() throws Exception
	{
		FetchGrantService fg = new FetchGrantService(sampleUsername, samplePassword);
		client.executeService(fg);
		assertNotNull(fg.getResult());
		
		FetchTokenService ft = new FetchTokenService(fg.getResult());
		client.executeService(ft);
		assertNotNull(ft.getResult());
	}
	
	@Test
	public void testAuthenticateByUserPass() throws Exception {
		client.setupAuthentication(sampleUsername, samplePassword);
		FetchMeService fm = new FetchMeService();
		client.executeService(fm);
		assertNotNull(fm.getResult());
		assertNotNull(fm.getResult().getUserName());
	}
	
	@Test
	public void testAuthenticateByGrantToken() throws Exception {
		FetchGrantService fg = new FetchGrantService(sampleUsername, samplePassword);
		client.executeService(fg);
		assertNotNull(fg.getResult());
		
		client.setupAuthentication(fg.getResult());
		FetchMeService fm = new FetchMeService();
		client.executeService(fm);
		assertNotNull(fm.getResult());
		assertNotNull(fm.getResult().getUserName());
	}
	

}
