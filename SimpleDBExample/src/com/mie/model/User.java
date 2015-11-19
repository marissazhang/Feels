package com.mie.model;

public class User {
	private int userid;
	private String username;
	private String email;
	private String password;
	private String designation;
	private String status;
	private String avatar;
	private String bio;

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getAvatar() {
		return avatar;
	}



	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getBio() {
		return bio;
	}



	public void setBio(String bio) {
		this.bio = bio;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + username
				+ ", lastName=" + email + ", dob=" + password + ", email="
				+ email + "]";
	}

}