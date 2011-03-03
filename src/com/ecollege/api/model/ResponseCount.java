package com.ecollege.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseCount implements Serializable {
	private long totalResponseCount;
	private long unreadResponseCount;
	private long personalResponseCount;
	private long last24HourResponseCount;
	
	public long getTotalResponseCount() {
		return totalResponseCount;
	}
	public void setTotalResponseCount(long totalResponseCount) {
		this.totalResponseCount = totalResponseCount;
	}
	public long getUnreadResponseCount() {
		return unreadResponseCount;
	}
	public void setUnreadResponseCount(long unreadResponseCount) {
		this.unreadResponseCount = unreadResponseCount;
	}
	public long getPersonalResponseCount() {
		return personalResponseCount;
	}
	public void setPersonalResponseCount(long personalResponseCount) {
		this.personalResponseCount = personalResponseCount;
	}
	public long getLast24HourResponseCount() {
		return last24HourResponseCount;
	}
	public void setLast24HourResponseCount(long last24HourResponseCount) {
		this.last24HourResponseCount = last24HourResponseCount;
	}
	
	
}
