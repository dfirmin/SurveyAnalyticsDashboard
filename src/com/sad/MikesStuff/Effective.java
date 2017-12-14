package com.sad.MikesStuff;

public class Effective {
	private int answerid;
	private int week;
	private String userresponse;
	
	public Effective() {
		
	}
	public int getAnswerid() {
		return answerid;
	}
	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public String getUserresponse() {
		return userresponse;
	}
	public void setUserresponse(String userresponse) {
		this.userresponse = userresponse;
	}
	@Override
	public String toString() {
		return "Effective [answerid=" + answerid + ", week=" + week + ", userresponse=" + userresponse + "]";
	}
	
}
