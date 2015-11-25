package com.mie.model;

import java.util.Date;

import com.mie.dao.ThreadDao;

public class Comment {
	private int CommentID;
	private int UserID;
	private int ThreadID;
	private String Comment;
	
	public String getUsername(){
		String username;
		ThreadDao dao = new ThreadDao();
		username = dao.getUsername(this.UserID);
		
		if(dao.isProfessional(this.UserID) == true){
			username = "* " + username;
		}
		return username;
	}
	
	public int getCommentID() {
		return CommentID;
	}

	public void setCommentID(int commentid) {
		this.CommentID = commentid;
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
	
	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		this.Comment = comment;
	}




}