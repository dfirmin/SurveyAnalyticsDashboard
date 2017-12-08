package com.sad.dto;

import java.io.Serializable;
import java.sql.Date;

public class Answer implements Serializable{
	
	private int answerID;
	private int personID;
	private int questionID;
	private int surveyID;
	private String userResponse;
	private String watsonResponse;
	private Date submitDate;
	
	
	public Answer() {
		
	}
	


	public Answer(int answerID, int personID, int questionID, int surveyID, String userResponse, String watsonResponse,
			Date submitDate) {
		super();
		this.answerID = answerID;
		this.personID = personID;
		this.questionID = questionID;
		this.surveyID = surveyID;
		this.userResponse = userResponse;
		this.watsonResponse = watsonResponse;
		this.submitDate = submitDate;
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





	public String getUserResponse() {
		return userResponse;
	}





	public void setUserResponse(String userResponse) {
		this.userResponse = userResponse;
	}





	public String getWatsonResponse() {
		return watsonResponse;
	}





	public void setWatsonResponse(String watsonResponse) {
		this.watsonResponse = watsonResponse;
	}





	public Date getSubmitDate() {
		return submitDate;
	}





	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}



	public int getSurveyID() {
		return surveyID;
	}



	public void setSurveyID(int surveyID) {
		this.surveyID = surveyID;
	}



	@Override
	public String toString() {
		return "Answer [answerID=" + answerID + ", personID=" + personID + ", questionID=" + questionID + ", surveyID="
				+ surveyID + ", userResponse=" + userResponse + ", watsonResponse=" + watsonResponse + ", submitDate="
				+ submitDate + "]";
	}
	
	

	
	
	
	
}
