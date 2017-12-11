package com.sad.dto;

import java.io.Serializable;

public class SurveyQADto implements Serializable{
	private int surveyQAID;
	private int questionID;
	private String questionText;
	private String questionType;
	private int offeredAnswerID;
	private String answerText;
	private Boolean isCustom;

	

	public SurveyQADto() {

	}

	
	public Boolean getIsCustom() {
		return isCustom;
	}

	public void setIsCustom(Boolean isCustom) {
		this.isCustom = isCustom;
	}
	public int getSurveyQAID() {
		return surveyQAID;
	}

	public void setSurveyQAID(int surveyQAID) {
		this.surveyQAID = surveyQAID;
	}
	public int getOfferedAnswerID() {
		return offeredAnswerID;
	}

	public void setOfferedAnswerID(int offeredAnswerID) {
		this.offeredAnswerID = offeredAnswerID;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

}
