package com.sad.dto;

import java.io.Serializable;

public class Survey_QA implements Serializable{
	private int SurveyQAID;
	private int SurveyID;
	private int questionID;
	private int offeredAnswerID;
	
	public Survey_QA() {
		
	}

	
	public Survey_QA(int surveyQAID, int surveyID, int questionID, int offeredAnswerID) {
		super();
		SurveyQAID = surveyQAID;
		SurveyID = surveyID;
		this.questionID = questionID;
		this.offeredAnswerID = offeredAnswerID;
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

	public int getOfferedAnswerID() {
		return offeredAnswerID;
	}

	public void setOfferedAnswerID(int offeredAnswerID) {
		this.offeredAnswerID = offeredAnswerID;
	}

	
	
	

}
