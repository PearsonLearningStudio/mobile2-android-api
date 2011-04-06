package com.ecollege.api.services.users;

import java.util.List;
import java.util.logging.Logger;

import com.ecollege.api.model.RosterUser;
import com.ecollege.api.services.BaseService;

public class FetchRosterService extends BaseService {
	@SuppressWarnings("unused")
	private static Logger l = Logger.getLogger(FetchRosterService.class.getName());
	
	private long courseId;
	
	private List<RosterUser> result;
	
	public FetchRosterService(long courseId) {
		this.courseId = courseId;
	}
	
	public List<RosterUser> getResult() {
		return result;
	}

	@Override
	public String getResource() {
		return "/courses/" + courseId + "/roster";
	}

	@Override
	public void processResponse(String responseContent) {
		super.processResponse(responseContent);
		result = parseContentAsJsonArray(responseContent,"roster", RosterUser.class);
	}
	
}
