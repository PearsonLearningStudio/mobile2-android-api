package com.ecollege.api.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Course implements Serializable {

    private long id;
    private String displayCourseCode;
    private String title;
    private List<String> callNumbers;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setDisplayCourseCode(String displayCourseCode) {
        this.displayCourseCode = displayCourseCode;
    }

    public String getDisplayCourseCode() {
        return displayCourseCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCallNumbers(List<String> callNumbers) {
        this.callNumbers = callNumbers;
    }

    public List<String> getCallNumbers() {
        return callNumbers;
    }
}

