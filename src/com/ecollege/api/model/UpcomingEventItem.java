package com.ecollege.api.model;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ecollege.api.model.links.Link;

@SuppressWarnings("serial")
public class UpcomingEventItem implements Serializable, Comparable<UpcomingEventItem> {

	public enum CategoryType {
		Start,
		End,
		Due
	}
	
	public enum UpcomingEventType {
		QuizExamTest,
		Thread,
		Html,
		Ignored
	}
	
	private WhenWrapper when;
	private long id;
	private String type;
	private String title;
	private String category;
	private List<Link> links;
	
	private long courseId = -1;
	public long getCourseId() {
		if (courseId == -1) {
			Pattern p = Pattern.compile("courses/([^\"\\/]*)",Pattern.CASE_INSENSITIVE);
			for (Link link : links) {
				Matcher matcher = p.matcher(link.getHref());
				
				if (matcher.find()) {
					String rawCourseId = matcher.group(1);
					courseId = Long.parseLong(rawCourseId);
				}
			}
		}
		return courseId;
	}
	
	public CategoryType getCategoryType() {
		if ("start".equalsIgnoreCase(getCategory())) return CategoryType.Start;
		if ("end".equalsIgnoreCase(getCategory())) return CategoryType.End;
		return CategoryType.Due;
	}
	
	public UpcomingEventType getEventType() {
		if ("HTML".equalsIgnoreCase(getType())) return UpcomingEventType.Html;
		if ("MANAGED_OD".equalsIgnoreCase(getType())) return UpcomingEventType.Html;
		if ("MANAGED_HTML".equalsIgnoreCase(getType())) return UpcomingEventType.Html;
		
		if ("THREAD".equalsIgnoreCase(getType())) return UpcomingEventType.Thread;
		if ("MANAGED_THREADS".equalsIgnoreCase(getType())) return UpcomingEventType.Thread;
		
		if ("IQT".equalsIgnoreCase(getType())) return UpcomingEventType.QuizExamTest;

		return UpcomingEventType.Ignored;
	}
	
	public long getThreadId() {
		return getId();
	}
	
	public long getMultimediaId() {
		return getId();
	}
	
	public WhenWrapper getWhen() {
		return when;
	}
	public void setWhen(WhenWrapper when) {
		this.when = when;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	private Object tag;
	public Object getTag() {
		return tag;
	}
	public void setTag(Object tag) {
		this.tag = tag;
	}

	@Override
	public int compareTo(UpcomingEventItem o) {
		if (getWhen() == null) return -1;
		if (getWhen().getTime() == null) return -1;
		if (o == null) return 1;
		if (o.getWhen() == null) return 1;
		if (o.getWhen().getTime() == null) return 1;
		if (getWhen().getTime().getTimeInMillis() < o.getWhen().getTime().getTimeInMillis()) return -1;
		if (getWhen().getTime().getTimeInMillis() > o.getWhen().getTime().getTimeInMillis()) return 1;
		return 0;
	}
	
}
