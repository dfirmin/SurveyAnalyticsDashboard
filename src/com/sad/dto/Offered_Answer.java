package com.sad.dto;

import java.io.Serializable;

public class Offered_Answer implements Serializable{

	private int offeredAnswerID;
	private String answerText;
	private boolean isCustom;
	


	public Offered_Answer() {
		
	}
	

	public Offered_Answer(int offeredAnswerID, String answerText, boolean isCustom) {
		super();
		this.offeredAnswerID = offeredAnswerID;
		this.answerText = answerText;
		this.isCustom = isCustom;
	}

	public boolean getIsCustom() {
		return isCustom;
	}


	public void setIsCustom(boolean isCustom) {
		this.isCustom = isCustom;
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
