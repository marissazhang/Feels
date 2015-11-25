package com.mie.model;

import com.mie.dao.ThreadDao;

public class Thread {
	private int ThreadID;
	private int UserID;
	private String Title;

	public String getUsername(){
		String username;
		ThreadDao dao = new ThreadDao();
		username = dao.getUsername(this.UserID);
		return username;
	}
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



/*	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", email="
				+ email + "]";
	}*/
}
