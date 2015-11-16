package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Thread;
import com.mie.model.Comment;
import com.mie.model.User;
import com.mie.util.DbUtil;

public class CommentDao {

	private Connection connection;

	public CommentDao() {
		connection = DbUtil.getConnection();
	}

	public void addComment(Comment comment) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Comments(UserID,ThreadID,Comment) values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, comment.getUserID());
			preparedStatement.setInt(2, comment.getThreadID());
			preparedStatement.setString(3, comment.getComment());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public List<Comment> getAllComments(int id) {
		List<Comment> comments = new ArrayList<Comment>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Comments WHERE ThreadID = " + id);
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setCommentID(rs.getInt("CommentID"));
				comment.setUserID(rs.getInt("UserID"));
				comment.setThreadID(rs.getInt("ThreadID"));
				comment.setComment(rs.getString("Comment"));
				comment.setTimestamp(rs.getDate("Timestamp"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comments;
	}


}