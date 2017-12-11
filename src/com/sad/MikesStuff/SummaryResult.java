/**
 * 
 */
package com.sad.MikesStuff;

import java.io.Serializable;

/**
 * @author mikechan
 *
 */
public class SummaryResult implements Serializable{
	
	private int pID;
	private String userResponse;
	private int cohortID;
	private int counter;
	
	
	public SummaryResult() {
		
	}


	public int getpID() {
		return pID;
	}


	public void setpID(int pID) {
		this.pID = pID;
	}


	public String getUserResponse() {
		return userResponse;
	}


	public void setUserResponse(String userResponse) {
		this.userResponse = userResponse;
	}


	public int getCohortID() {
		return cohortID;
	}


	public void setCohortID(int cohortID) {
		this.cohortID = cohortID;
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


	@Override
	public String toString() {
		return "SummaryResult [pID=" + pID + ", userResponse=" + userResponse + ", cohortID=" + cohortID + ", counter="
				+ counter + "]";
	}


	
	
	
}
