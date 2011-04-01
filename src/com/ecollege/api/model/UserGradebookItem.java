package com.ecollege.api.model;

import java.io.Serializable;
import java.util.List;

import com.ecollege.api.model.links.GradeLink;

@SuppressWarnings("serial")
public class UserGradebookItem implements Serializable {

	private String id;
	private GradebookItem gradebookItem;
	private List<GradeLink> gradeLinks;
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setGradebookItem(GradebookItem gradebookItem) {
		this.gradebookItem = gradebookItem;
	}
	public GradebookItem getGradebookItem() {
		return gradebookItem;
	}
	
	public Grade getGrade() {
		if (null != gradeLinks && gradeLinks.size() > 0) {
			GradeLink link = gradeLinks.get(0);
			return link.getGrade();
		}
		return null;
	}
} 