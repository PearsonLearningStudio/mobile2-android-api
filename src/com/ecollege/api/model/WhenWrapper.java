package com.ecollege.api.model;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class WhenWrapper implements Serializable {
	
	private Calendar time;

	public Calendar getTime() {
		return time;
	}

	public void setTime(Calendar time) {
		this.time = time;
	}
	
}
