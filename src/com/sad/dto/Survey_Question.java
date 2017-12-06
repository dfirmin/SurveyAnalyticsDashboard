package com.sad.dto;

import java.io.Serializable;

public class Survey_Question implements Serializable{

	private int surveyID;
	private int questionID;
	
	
	public Survey_Question() {
		
	}
	
	

	public Survey_Question(int surveyID, int questionID) {
		super();
		this.surveyID = surveyID;
		this.questionID = questionID;
	}



	public int getSurveyID() {
		return surveyID;
	}

	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	
}
