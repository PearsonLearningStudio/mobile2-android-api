package com.ecollege.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

/*
{
    "gradebookItems":[
        {
            "type":"courseItem",
            "id":"a24e4de6-9b8a-4f9e-b85b-5fa13134a8f3",
            "title":"text item due yesterday",
            "pointsPossible":10.00,
            "links":[{
                "href":"http://m-api.ecollege-labs.com/courses/2022295/items/1003239665",
                "rel":"related"
            }]
        }
    ]
}
 */


@SuppressWarnings("serial")
public class GradebookItem implements Serializable {

	private String type;
	private String id;
	private String title;
	private BigDecimal pointsPossible;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPointsPossible() {
		return pointsPossible;
	}
	public void setPointsPossible(BigDecimal pointsPossible) {
		this.pointsPossible = pointsPossible;
	}
	
}
