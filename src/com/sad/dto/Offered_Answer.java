package com.sad.dto;

import java.io.Serializable;

public class Offered_Answer implements Serializable{

	private int offeredAnswerID;
	private String answerText;
	
	public Offered_Answer() {
		
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
	
	
}
