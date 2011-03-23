package com.ecollege.api.model;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class Announcement implements Serializable {

	private long id;
	private String subject;
	private String text;
	private String submitter;
	private Calendar startDisplayDate;
	private Calendar endDisplayDate;
	private String rawText;
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubject() {
		return subject;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}
	public String getRawText() {
		// memoize to avoid extra processing
		if (rawText == null) {
			// remove tags (naively for now) and beginning and ending whitespace
			rawText = text.replaceAll("<[^>]+>", "").trim();
		}
		return rawText;
	}
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	public String getSubmitter() {
		return submitter;
	}
	public void setStartDisplayDate(Calendar startDisplayDate) {
		this.startDisplayDate = startDisplayDate;
	}
	public Calendar getStartDisplayDate() {
		return startDisplayDate;
	}
	public void setEndDisplayDate(Calendar endDisplayDate) {
		this.endDisplayDate = endDisplayDate;
	}
	public Calendar getEndDisplayDate() {
		return endDisplayDate;
	}
}
