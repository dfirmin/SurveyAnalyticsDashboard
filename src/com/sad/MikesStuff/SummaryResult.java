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
	private int counter;
	private int week;
	
	
	public int getWeek() {
		return week;
	}


	public void setWeek(int week) {
		this.week = week;
	}


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


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


	@Override
	public String toString() {
		return "SummaryResult [pID=" + pID + ", userResponse=" + userResponse + ", counter=" + counter + ", week="
				+ week + "]";
	}


	
	
	
}
