package com.ecollege.api.services.courses;

import java.util.List;
import java.util.logging.Logger;

import com.ecollege.api.model.Course;
import com.ecollege.api.services.BaseService;

public class FetchMyCoursesService extends BaseService {

	private static Logger l = Logger.getLogger(FetchMyCoursesService.class.getName());
	private List<Course> result;
	
	public List<Course> getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/me/currentcourses_moby";
	}

	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJsonArray(responseContent,"currentCourses", Course.class);
		l.finest("Result is " + result);
	}
	
}
