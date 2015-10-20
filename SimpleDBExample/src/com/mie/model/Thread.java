package com.mie.model;

import java.util.Date;

public class Thread {
	private int ThreadID;
	private int UserID;
	private String Title;
	private Date Date_of_Post;

	public int getThreadID() {
		return ThreadID;
	}

	public void setThreadID(int threadid) {
		this.ThreadID = threadid;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userid) {
		this.UserID = userid;
	}
	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}

	public Date getDoP() {
		return Date_of_Post;
	}

	public void setDoP(Date doP) {
		this.Date_of_Post = doP;
	}


/*	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email + "]";
	}*/
}
