package com.sad.dto;

import java.io.Serializable;
import java.util.Calendar;


public class Cohort implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cohortID;
	private String cohortName;
	private String cohortSemester;
	private String startDate;
	
	public Cohort() {
		
	}
	
	
	

	public Cohort(int cohortID, String cohortName, String cohortSemester, String startDate) {
		super();
		this.cohortID = cohortID;
		this.cohortName = cohortName;
		this.cohortSemester = cohortSemester;
		this.startDate = startDate;
	}




	public int getCohortID() {
		return cohortID;
	}

	public void setCohortID(int cohortID) {
		this.cohortID = cohortID;
	}

	public String getCohortName() {
		return cohortName;
	}

	public void setCohortName(String cohortName) {
		this.cohortName = cohortName;
	}

	public String getCohortSemester() {
		return cohortSemester;
	}

	public void setCohortSemester(String cohortSemester) {
		this.cohortSemester = cohortSemester;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	
	
	

}
