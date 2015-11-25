package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.User;
import com.mie.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(User user) {
		
		//this if statement ensures we only add UofT people
		if (user.getEmail().contains("utoronto.ca")) {
		
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into Users(Username, Email, Password, Designation, Status, Bio) values (?, ?, ?, ?, ?, ? )");
				// Parameters start with 1
				preparedStatement.setString(1, user.getUsername());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setString(3, user.getPassword());
				preparedStatement.setString(5, user.getStatus());
				preparedStatement.setString(6, user.getBio());
				
				//this if statement will designate user as student/professional based on email
				if (user.getEmail().contains("mail.utoronto.ca")) {
					preparedStatement.setString(4, "Student");
				}
				else {
					preparedStatement.setString(4, "Professional");
				}
				preparedStatement.executeUpdate();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
//

//
//	public void updateUser(User user) {
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?"
//							+ " where userid=?");
//			// Parameters start with 1
//			preparedStatement.setString(1, user.getFirstName());
//			preparedStatement.setString(2, user.getLastName());
//			preparedStatement.setDate(3, new java.sql.Date(user.getDob()
//					.getTime()));
//			preparedStatement.setString(4, user.getEmail());
//			preparedStatement.setInt(5, user.getUserid());
//			preparedStatement.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("Userid"));
				user.setUsername(rs.getString("Username"));
				user.setEmail(rs.getString("Email"));
				user.setPassword(rs.getString("Password"));
				user.setDesignation(rs.getString("Designation"));
				user.setStatus(rs.getString("Status"));
				user.setAvatar(rs.getString("Bio"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User getUserByUsername(String username) {
	User user = new User();
	try {
		PreparedStatement preparedStatement = connection
				.prepareStatement("select * from users where username=?");
		preparedStatement.setString(1, username);
		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			user.setUsername(rs.getString("Username"));
			user.setEmail(rs.getString("Email"));
			user.setPassword(rs.getString("Password"));
			user.setDesignation(rs.getString("Designation"));
			user.setStatus(rs.getString("Status"));
			user.setBio(rs.getString("Bio"));
			user.setUserid(rs.getInt("UserID"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return user;
}

//	public void deleteUser(int userId) {
//try {
//PreparedStatement preparedStatement = connection
//		.prepareStatement("delete from users where userid=?");
//// Parameters start with 1
//preparedStatement.setInt(1, userId);
//preparedStatement.executeUpdate();
//
//} catch (SQLException e) {
//e.printStackTrace();
//}
//}
	
	
	public void deleteUser(String username, String password) {
		
		try {
		PreparedStatement preparedStatement = connection.prepareStatement("delete from users where username=? AND password=?");
		// Parameters start with 1
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		preparedStatement.executeUpdate();
		
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
	}

	public boolean verifyPassword(String username, String passwordEntered) {
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users where username=?");
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				if (passwordEntered.equals(rs.getString("Password"))){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void updateUser(User user) {
		//Username and email cannot be changed/updated.
		//Should we leave it like this
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set password=?, status=?, bio=?"
							+ " where username=?");
			// Parameters start with 1
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getStatus());
			preparedStatement.setString(3, user.getBio());
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
//	public User getUserById(int userId) {
//		User user = new User();
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("select * from users where userid=?");
//			preparedStatement.setInt(1, userId);
//			ResultSet rs = preparedStatement.executeQuery();
//
//			if (rs.next()) {
//				user.setUserid(rs.getInt("userid"));
//				user.setFirstName(rs.getString("firstname"));
//				user.setLastName(rs.getString("lastname"));
//				user.setDob(rs.getDate("dob"));
//				user.setEmail(rs.getString("email"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return user;
//	}
}