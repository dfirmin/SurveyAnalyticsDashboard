package com.sad.dto;

import java.io.Serializable;

public class Survey_QA implements Serializable{
	private int SurveyQAID;
	private int SurveyID;
	private int questionID;
	private int offeredAnsweriD;
	
	public Survey_QA() {
		
	}

	public int getSurveyQAID() {
		return SurveyQAID;
	}

	public void setSurveyQAID(int surveyQAID) {
		SurveyQAID = surveyQAID;
	}

	public int getSurveyID() {
		return SurveyID;
	}

	public void setSurveyID(int surveyID) {
		SurveyID = surveyID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getOfferedAnsweriD() {
		return offeredAnsweriD;
	}

	public void setOfferedAnsweriD(int offeredAnsweriD) {
		this.offeredAnsweriD = offeredAnsweriD;
	}
	
	

}
