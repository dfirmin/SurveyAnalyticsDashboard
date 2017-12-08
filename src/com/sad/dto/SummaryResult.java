/**
 * 
 */
package com.sad.dto;

import java.io.Serializable;

/**
 * @author mikechan
 *
 */
public class SummaryResult implements Serializable{
	

	private String UserResponse;
	private int CohortID;
	private int counter;
	
	
	public SummaryResult() {
		
	}
	public String getUserResponse() {
		return UserResponse;
	}
	public void setUserResponse(String userResponse) {
		UserResponse = userResponse;
	}
	public int getCohortID() {
		return CohortID;
	}
	public void setCohortID(int cohortID) {
		CohortID = cohortID;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	@Override
	public String toString() {
		return "SummaryResult [UserResponse=" + UserResponse + ", CohortID=" + CohortID + ", counter=" + counter + "]";
	}
	
	
	
}
