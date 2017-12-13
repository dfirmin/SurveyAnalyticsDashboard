package com.sad.MikesStuff;

import java.io.Serializable;

public class WhatConf implements Serializable {
	@Override
	public String toString() {
		return "WhatConf [pid=" + pid + ", cohortid=" + cohortid + ", watsonresponse=" + watsonresponse + ", count="
				+ count + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCohortid() {
		return cohortid;
	}
	public void setCohortid(int cohortid) {
		this.cohortid = cohortid;
	}
	public String getWatsonresponse() {
		return watsonresponse;
	}
	public void setWatsonresponse(String watsonresponse) {
		this.watsonresponse = watsonresponse;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	private int pid;
	private int cohortid;
	private String watsonresponse;
	private int count;
}
