package com.sad.MikesStuff;

public class ProgramManagement {
	private int answerid;
	private int questionid;
	private String userresponse;
	private String watsonresponse;

	public String getWatsonresponse() {
		return watsonresponse;
	}

	public void setWatsonresponse(String watsonresponse) {
		this.watsonresponse = watsonresponse;
	}

	public ProgramManagement() {
	
	}


	@Override
	public String toString() {
		return "ProgramManagement [answerid=" + answerid + ", questionid=" + questionid + ", userresponse="
				+ userresponse + ", watsonresponse=" + watsonresponse + "]";
	}

	public int getAnswerid() {
		return answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getUserresponse() {
		return userresponse;
	}

	public void setUserresponse(String userresponse) {
		this.userresponse = userresponse;
	}

}