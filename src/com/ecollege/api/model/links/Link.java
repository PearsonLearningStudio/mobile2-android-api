package com.ecollege.api.model.links;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Link implements Serializable {
	
	private String href;
	private String rel;
	private String title;
	public void setHref(String href) {
		this.href = href;
	}
	public String getHref() {
		return href;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getRel() {
		return rel;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
}
