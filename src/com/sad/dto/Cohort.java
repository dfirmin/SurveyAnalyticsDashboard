package com.sad.dto;

import java.io.Serializable;
import java.sql.Date;

public class Cohort implements Serializable {
	private int cohortID;
	private String cohortName;
	private String cohortSemester;
	private Date startDate;
	
	public Cohort() {
		
	}
	
	
	

	public Cohort(int cohortID, String cohortName, String cohortSemester, Date startDate) {
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


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
	
	

}
