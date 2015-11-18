package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Comment;
import com.mie.model.Thread;
import com.mie.util.DbUtil;

public class ThreadDao {

	private Connection connection;

	public ThreadDao() {
		connection = DbUtil.getConnection();
	}

	public void addThread(Thread thread) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Threads(UserID,Title) values (?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, thread.getUserID());
			preparedStatement.setString(2, thread.getTitle());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from users where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?"
							+ " where userid=?");
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDob()
					.getTime()));
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setInt(5, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/

	public List<Thread> getAllThreads() {
		List<Thread> threads = new ArrayList<Thread>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Threads");
			while (rs.next()) {
				Thread thread = new Thread();
				thread.setThreadID(rs.getInt("ThreadID"));
				thread.setUserID(rs.getInt("UserID"));
				thread.setTitle(rs.getString("Title"));
				thread.setDoP(rs.getDate("Date"));
				threads.add(thread);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return threads;
	}

	/*public User getThreadById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}*/
}