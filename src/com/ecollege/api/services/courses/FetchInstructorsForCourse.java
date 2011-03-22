package com.ecollege.api.services.courses;

import java.util.List;

import com.ecollege.api.model.Course;
import com.ecollege.api.model.User;
import com.ecollege.api.services.BaseService;

public class FetchInstructorsForCourse extends BaseService {
	
	private Course course;
	private List<User> result;

	public FetchInstructorsForCourse(Course course) {
		this.course = course;
	}
	
	@Override public String getResource() {
		return "/courses/" + course.getId() + "/instructors";
	}
	
	@Override public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJsonArray(responseContent, "instructors", User.class);
	}

	public List<User> getResult() {
		return result;
	}

}
