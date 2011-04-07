package com.ecollege.api.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {

    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String clientString;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setClientString(String clientString) {
        this.clientString = clientString;
    }

    public String getClientString() {
        return clientString;
    }
    
    public String getDisplayName() {
    	return firstName + " " + lastName;
    }
}
