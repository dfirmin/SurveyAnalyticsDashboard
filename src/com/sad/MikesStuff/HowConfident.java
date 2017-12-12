package com.sad.MikesStuff;

public class HowConfident {
	
	private int answerid;
	private double userresponse;
	private int week;
	private int cohortid;
	
	public HowConfident() {
		
	}

	@Override
	public String toString() {
		return "HowConfident [answerid=" + answerid + ", userresponse=" + userresponse + ", week=" + week
				+ ", cohortid=" + cohortid + "]";
	}

	public int getAnswerid() {
		return answerid;
	}

	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}

	public double getUserresponse() {
		return userresponse;
	}

	public void setUserresponse(double userresponse) {
		this.userresponse = userresponse;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getCohortid() {
		return cohortid;
	}

	public void setCohortid(int cohortid) {
		this.cohortid = cohortid;
	}
}
