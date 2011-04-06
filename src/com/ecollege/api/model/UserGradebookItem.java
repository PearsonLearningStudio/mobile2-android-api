package com.ecollege.api.model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

import com.ecollege.api.model.links.GradeLink;

@SuppressWarnings("serial")
public class UserGradebookItem implements Serializable {

	private static final DecimalFormat df = new DecimalFormat();
	
	private String id;
	private GradebookItem gradebookItem;
	private List<GradeLink> links;
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
	
	public List<GradeLink> getLinks() {
		return links;
	}
	public void setLinks(List<GradeLink> links) {
		this.links = links;
	}
	public Grade getGrade() {
		if (null != links && links.size() > 0) {
			GradeLink link = links.get(0);
			return link.getGrade();
		}
		return null;
	}
	
	public String getDisplayedGrade() {
		Grade g = getGrade();
		if (g == null) return null;
		if (gradebookItem.getPointsPossible() != null && g.getPoints() != null) {
			return df.format(g.getPoints()) + "/" + df.format(gradebookItem.getPointsPossible());
		} else if (g.getLetterGrade() != null) {
			return g.getLetterGrade();
		} else {
			return null;
		}
	}
} 