package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.ResourceDao;
import com.mie.dao.SymptomDao;
import com.mie.dao.UserDao;
import com.mie.model.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/newUser.jsp";
	private static String REC = "/recommendations.jsp";
	private static String RESOURCES = "/resources.jsp";
	private static String LIST_USER = "/listUsers.jsp";
	private static String USERPROFILE = "/userProfile.jsp";
	private static String DELETEPROFILE = "/deleteProfile.jsp";
	private static String EDITPROFILE = "/editProfile.jsp";
	private static String EDITUSERVERIFICATION = "/editUserVerification.jsp";
	private UserDao dao;
	private SymptomDao dao2;
	private ResourceDao dao3;

	public UserController() {
		super();
		dao = new UserDao();
		dao2 = new SymptomDao();
		dao3 = new ResourceDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

//		if (action.equalsIgnoreCase("delete")) {
//			int userId = Integer.parseInt(request.getParameter("userId"));
//			dao.deleteUser(userId);
//			forward = LIST_USER;
//			request.setAttribute("users", dao.getAllUsers());
//		} else if (action.equalsIgnoreCase("edit")) {
//			forward = INSERT_OR_EDIT;
//			int userId = Integer.parseInt(request.getParameter("userId"));
//			User user = dao.getUserById(userId);
//			request.setAttribute("user", user);
		if (action.equalsIgnoreCase("listUsers")) {
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else if (action.equalsIgnoreCase("rec")) {
			forward = REC;
			request.setAttribute("symptoms", dao2.getAllSymptoms());
		} else if (action.equalsIgnoreCase("symptomInput")) {
			forward = RESOURCES;
		} else if (action.equalsIgnoreCase("userProfile")){
			forward = USERPROFILE;
			String username = request.getParameter("username");
			User user = dao.getUserByUsername(username);
			request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("deletePage")){
			forward = DELETEPROFILE;
			String username = request.getParameter("username");
			User user = dao.getUserByUsername(username);
			request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("editUserVerification")){
			forward = EDITUSERVERIFICATION;
			String username = request.getParameter("username");
			User user = dao.getUserByUsername(username);
			request.setAttribute("user", user);
		} 
		else {
			forward = INSERT_OR_EDIT;
			//forward = USERPROFILE;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		///NEW CHANGES: ADDED 'action' parameter to doPost
		String forward = "";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("newUser")) {
			User user = new User();
			System.out.println("it enters the doPost");
			user.setUsername(request.getParameter("userName"));
			user.setPassword(request.getParameter("password"));
			user.setEmail(request.getParameter("email"));
			user.setStatus(request.getParameter("status"));
			user.setBio(request.getParameter("bio"));
			dao.addUser(user);
			//NEW
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		}
		else if (action.equalsIgnoreCase("editUser")) {
			User user = new User();
			user.setUsername(request.getParameter("userName"));
			user.setPassword(request.getParameter("password"));
			user.setEmail(request.getParameter("email"));
			user.setStatus(request.getParameter("status"));
			user.setBio(request.getParameter("bio"));
			dao.updateUser(user);
			//NEW
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		}
		else if (action.equalsIgnoreCase("deleteUser")){
				forward = LIST_USER;
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				dao.deleteUser(username, password);
				request.setAttribute("users", dao.getAllUsers());
			}  
		
		else if (action.equalsIgnoreCase("symptomInput")){
			forward = RESOURCES;
			request.setAttribute("symptomResources", dao3.getResources(request.getParameterNames()));
		}
		else if (action.equalsIgnoreCase("verifyPassord")){
			
			String username = request.getParameter("username");
			String passwordEntered = request.getParameter("password");
			User user = dao.getUserByUsername(username);

//			boolean correctPassword = true;
			boolean correctPassword = dao.verifyPassword(username, passwordEntered);

			//if password correct //go to edit
			if (correctPassword){
				forward = EDITPROFILE;
				request.setAttribute("user", user);
			}
			//else //go to user list 
			else {
				forward = LIST_USER;
				request.setAttribute("users", dao.getAllUsers());
			}
			
		}  
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}