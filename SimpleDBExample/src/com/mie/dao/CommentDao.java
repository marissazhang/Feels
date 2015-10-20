package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mie.model.Thread;
import com.mie.util.DbUtil;

public class CommentDao {

	private Connection connection;

	public CommentDao() {
		connection = DbUtil.getConnection();
	}



	public List<Thread> getAllComments() {
		List<Thread> threads = new ArrayList<Thread>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Threads");
			while (rs.next()) {
				Thread thread = new Thread();
				thread.setThreadID(rs.getInt("ThreadID"));
				thread.setUserID(rs.getInt("UserID"));
				thread.setTitle(rs.getString("Title"));
				thread.setDoP(rs.getDate("Date_of_Post"));
				threads.add(thread);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return threads;
	}


}