package com.sad.MikesStuff;

import java.io.Serializable;

public class QOptions implements Serializable{
	private int surveyqaid;
	private int questionid;
	private int offeredanswerid;
	private String answertext;
	
	public QOptions() {
		
	}

	public int getSurveyqaid() {
		return surveyqaid;
	}

	public void setSurveyqaid(int surveyqaid) {
		this.surveyqaid = surveyqaid;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getOfferedanswerid() {
		return offeredanswerid;
	}

	public void setOfferedanswerid(int offeredanswerid) {
		this.offeredanswerid = offeredanswerid;
	}

	public String getAnswertext() {
		return answertext;
	}

	public void setAnswertext(String answertext) {
		this.answertext = answertext;
	}

	@Override
	public String toString() {
		return "QOptions [surveyqaid=" + surveyqaid + ", questionid=" + questionid + ", offeredanswerid="
				+ offeredanswerid + ", answertext=" + answertext + "]";
	}
	
}
