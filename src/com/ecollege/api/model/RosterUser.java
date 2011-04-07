package com.ecollege.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RosterUser implements Serializable,Comparable<RosterUser> {

	public static final String ROLE_CODE_INSTRUCTOR = "Instructor";
	public static final String ROLE_CODE_STUDENT = "Student";
	
    private long id;
    private String roleType;
    private String firstName;
    private String lastName;
    private String personaId;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPersonaId() {
		return personaId;
	}
	public void setPersonaId(String personaId) {
		this.personaId = personaId;
	}
	
	public String getDisplayName() {
		return getFirstName() + " " + getLastName();
	}
	
	public String getLastNameFirstChar() {
		if (lastName != null && lastName.length() > 0) {
			return lastName.substring(0,1).toUpperCase();
		}
		return "?";
	}
	
	public String getRoleCode() {
		return getFriendlyRole(); //if internationalized, make sure this returns the constants at top
	}
	
	public String getFriendlyRole() {
		String lowerRole = getRoleType() == null ? "?" : getRoleType().toLowerCase();
		if ("prof".equals(lowerRole)) return "Instructor";
		if ("stud".equals(lowerRole)) return "Student";
		return getRoleType();
	}
	
	@Override
	public int compareTo(RosterUser o) {
		if (o == null) return 1;
		if (getLastName() == null) return -1;
		int lastCompare = getLastName().compareTo(o.getLastName());
		if (lastCompare != 0) return lastCompare;
		if (getFirstName() == null) return -1;
		return getFirstName().compareTo(o.getFirstName());
	}
}
