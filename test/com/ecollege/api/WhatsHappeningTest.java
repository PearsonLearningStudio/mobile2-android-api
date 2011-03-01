package com.ecollege.api;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ecollege.api.model.ActivityStreamItem;
import com.ecollege.api.services.activities.FetchMyWhatsHappeningFeed;

public class WhatsHappeningTest extends BaseTest {

	protected ECollegeClient client;
	
	@Before
	public void setUp() throws Exception {
		client = new ECollegeClient(clientString, clientId);
		client.setupAuthentication(sampleUsername, samplePassword);
	}
	
	@Test
	public void testFetchMyWhatsHappeningFeed() throws Exception {
		FetchMyWhatsHappeningFeed fmwhf = new FetchMyWhatsHappeningFeed();
		client.executeService(fmwhf);
		assertNotNull(fmwhf.getResult());
		assertTrue("more than one feed item", fmwhf.getResult().size() > 0);
		for (ActivityStreamItem asi : fmwhf.getResult()) {
			assertNotNull(asi.getObject());
			assertNotNull(asi.getObject().getObjectType());
		}
	}
	

}
