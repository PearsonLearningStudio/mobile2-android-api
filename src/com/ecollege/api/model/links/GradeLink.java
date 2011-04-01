package com.ecollege.api.model.links;

import com.ecollege.api.model.Grade;

@SuppressWarnings("serial")
public class GradeLink extends Link {
	
	private Grade grade;

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Grade getGrade() {
		return grade;
	}
	
}
