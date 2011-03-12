package com.ecollege.api.services.courses;

import java.util.List;
import java.util.logging.Logger;

import com.ecollege.api.model.Course;
import com.ecollege.api.services.BaseService;

public class FetchCourseByIdService extends BaseService{

	private static Logger l = Logger.getLogger(FetchCourseByIdService.class.getName());
	private long courseId;
	private Course result;

	public FetchCourseByIdService(long courseId) {
		this.courseId = courseId;
	}
	
	@Override public String getResource() {
		return "/courses/" + courseId;
	}
	
	@Override public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		List<Course> courseList = parseContentAsJsonArray(responseContent, "courses", Course.class);
		result = courseList.get(0);
		l.finest("Result of fetching course: " + result);
	}

	public Course getResult() {
		return result;
	}

}
