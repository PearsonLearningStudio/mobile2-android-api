package com.ecollege.api;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.ecollege.api.model.Course;
import com.ecollege.api.services.courses.FetchMyCoursesService;
import com.ecollege.api.services.discussions.FetchDiscussionTopicsForCourseIds;
import com.ecollege.api.services.users.FetchMeService;

public class DiscussionsTest extends BaseTest {

	private static Logger l = Logger.getLogger(DiscussionsTest.class.getName());
	protected ECollegeClient client;
	
	@Before
	public void setUp() throws Exception {
		client = new ECollegeClient(clientString, clientId);
		client.setupAuthentication(sampleUsername, samplePassword);
	}
	
	@Test
	public void testFetchTopicsForCourse() throws Exception {
		

		FetchMeService fm = new FetchMeService();
		client.executeService(fm);
		assertNotNull(fm.getResult());
		
		l.finest("Current user id is " + fm.getResult().getId());
		
		FetchMyCoursesService fmc = new FetchMyCoursesService();
		client.executeService(fmc);
		assertNotNull(fmc.getResult());
		assertTrue("more than one course", fmc.getResult().size() > 0);
		
		List<String> courseIds = new ArrayList<String>(); 
		for (Course c : fmc.getResult()) { courseIds.add(c.getId() + ""); } 
		FetchDiscussionTopicsForCourseIds fetcht = new FetchDiscussionTopicsForCourseIds(courseIds);
		client.executeService(fetcht);
		
		l.finest("FetchTopicsForCourse size: " + fetcht.getResult().size());
		
	}
	
	

}
