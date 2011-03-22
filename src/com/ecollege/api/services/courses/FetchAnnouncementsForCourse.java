package com.ecollege.api.services.courses;

import java.util.List;

import com.ecollege.api.model.Announcement;
import com.ecollege.api.model.Course;
import com.ecollege.api.services.BaseService;

public class FetchAnnouncementsForCourse extends BaseService {
	
	private Course course;
	private boolean excludeInactive;
	private List<Announcement> result;
	
	public FetchAnnouncementsForCourse(Course course) {
		this.course = course;
	}

	public FetchAnnouncementsForCourse(Course course, boolean excludeInactive) {
		this.course = course;
		this.excludeInactive = excludeInactive;
	}

	@Override public String getResource() {
		String resource = "/courses/" + course.getId() + "/announcements";
		if (excludeInactive) {
			resource = resource + "?excludeInactive=true";
		}
		return resource;
	}
	
	@Override public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJsonArray(responseContent, "announcements", Announcement.class);
	}

	public List<Announcement> getResult() {
		return result;
	}

}
