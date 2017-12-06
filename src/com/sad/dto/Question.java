package com.sad.dto;

import java.io.Serializable;

public class Question implements Serializable{

	private static final long serialVersionUID = -7356239409367121445L;
	private int questionID;
	private String questionText;
	private String questionType;
	
	public Question() {
		
	}
	
	

	public Question(int questionID, String questionText, String questionType) {
		super();
		this.questionID = questionID;
		this.questionText = questionText;
		this.questionType = questionType;
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
