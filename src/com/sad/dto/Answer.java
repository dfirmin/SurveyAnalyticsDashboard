package com.sad.dto;

import java.io.Serializable;

public class Answer implements Serializable{
	
	private int answerID;
	private int personID;
	private int questionID;
	private int offeredAnswerID;
	
	public Answer() {
		
	}

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getOfferedanswerid() {
		return offeredAnswerID;
	}

	public void setOfferedanswerid(int offeredanswerid) {
		this.offeredAnswerID = offeredanswerid;
	}
	
	
}
