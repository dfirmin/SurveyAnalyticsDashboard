package com.sad.dto;

import java.io.Serializable;

public class Cohort implements Serializable {
	private int cohortID;
	private String cohortName;
	private String cohortSemester;
	
	public Cohort() {
		
	}
	
	
	public Cohort(int cohortID, String cohortName, String cohortSemester) {
		super();
		this.cohortID = cohortID;
		this.cohortName = cohortName;
		this.cohortSemester = cohortSemester;
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
	
	

}
