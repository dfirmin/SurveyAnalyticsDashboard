package com.sad.dto;

import java.io.Serializable;

public class Jobs_Applied implements Serializable {
	private int count;
	private String jobs_applied_label;
	
	public Jobs_Applied() {
		
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getJobs_applied_label() {
		return jobs_applied_label;
	}
	public void setJobs_applied_label(String jobs_applied_label) {
		this.jobs_applied_label = jobs_applied_label;
	}
	@Override
	public String toString() {
		return "Jobs_Applied [count=" + count + ", jobs_applied_label=" + jobs_applied_label + "]";
	}
	
}
