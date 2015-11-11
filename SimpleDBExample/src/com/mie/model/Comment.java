package com.mie.model;

import java.util.Date;

public class Comment {
	private int CommentID;
	private int UserID;
	private int ThreadID;
	private String Comment;
	private Date Timestamp;
	
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

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.Timestamp = timestamp;
	}



}