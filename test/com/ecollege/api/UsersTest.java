package com.ecollege.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ecollege.api.services.users.FetchMeService;
import com.ecollege.api.services.users.FetchUserByIdService;

public class UsersTest extends BaseTest {

	protected ECollegeClient client;
	
	@Before
	public void setUp() throws Exception {
		client = new ECollegeClient(clientString, clientId);
		client.setupAuthentication(sampleUsername, samplePassword);
	}
	
	@Test
	public void testFetchUserById() throws Exception
	{
		FetchMeService fm = new FetchMeService();
		client.executeService(fm);
		assertNotNull(fm.getResult());
		assertNotNull(fm.getResult().getUserName());
		
		FetchUserByIdService fui = new FetchUserByIdService(fm.getResult().getId());
		client.executeService(fui);
		assertNotNull(fui.getResult());
		assertNotNull(fui.getResult().getUserName());
	}
	
}
