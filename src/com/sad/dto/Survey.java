package com.sad.dto;

import java.io.Serializable;
import java.sql.Date;

public class Survey implements Serializable{

	private int surveyID;
	private String description;
	private Date frequency;
	private Date createDate;
	
	public Survey() {
		
	}
	
	

	public Survey(int surveyID, String description, Date frequency, Date createDate) {
		super();
		this.surveyID = surveyID;
		this.description = description;
		this.frequency = frequency;
		this.createDate = createDate;
	}



	public int getSurveyID() {
		return surveyID;
	}

	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFrequency() {
		return frequency;
	}

	public void setFrequency(Date frequency) {
		this.frequency = frequency;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

}
