package com.ecollege.api;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ecollege.api.model.Course;
import com.ecollege.api.services.courses.FetchMyCoursesService;

public class CoursesTest extends BaseTest {

	protected ECollegeClient client;
	
	@Before
	public void setUp() throws Exception {
		client = new ECollegeClient(clientString, clientId);
		client.setupAuthentication(sampleUsername, samplePassword);
	}
	
	@Test
	public void testAuthenticateByUserPass() throws Exception {
		FetchMyCoursesService fmc = new FetchMyCoursesService();
		client.executeService(fmc);
		assertNotNull(fmc.getResult());
		assertTrue("more than one course", fmc.getResult().size() > 0);
		for (Course c : fmc.getResult()) {
			assertNotNull(c.getTitle());
		}
	}
	

}
