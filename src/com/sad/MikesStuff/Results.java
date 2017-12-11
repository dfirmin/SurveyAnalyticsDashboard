package com.sad.MikesStuff;

import java.io.Serializable;

public class Results implements Serializable{
	private int answerid;
	private int personid;
	private String firstname;
	private String lastname;
	private String cohortname;
	private String submitdate;
	private int questionid;
	private int surveyid;
	private String userresponse;
	private String watsonresponse;
	
	public int getAnswerid() {
		return answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}
	
	public Results() {
		
	}

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCohortname() {
		return cohortname;
	}

	public void setCohortname(String cohortname) {
		this.cohortname = cohortname;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public int getSurveyid() {
		return surveyid;
	}

	public void setSurveyid(int surveyid) {
		this.surveyid = surveyid;
	}

	public String getUserresponse() {
		return userresponse;
	}

	public void setUserresponse(String userresponse) {
		this.userresponse = userresponse;
	}

	public String getWatsonresponse() {
		return watsonresponse;
	}

	public void setWatsonresponse(String watsonresponse) {
		this.watsonresponse = watsonresponse;
	}

	public String getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(String submitdate) {
		this.submitdate = submitdate;
	}

	@Override
	public String toString() {
		return "Results [personid=" + personid + ", firstname=" + firstname + ", lastname=" + lastname + ", cohortname="
				+ cohortname + ", questionid=" + questionid + ", surveyid=" + surveyid + ", userresponse="
				+ userresponse + ", watsonresponse=" + watsonresponse + ", submitdate=" + submitdate + "]";
	}
}
