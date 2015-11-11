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

import com.mie.dao.*;
import com.mie.model.User;
import com.mie.model.Thread;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/thread.jsp";
	private static String LIST_USER = "/forum.jsp";
	private ThreadDao dao;
	private CommentDao commentdao;

	public UserController() {
		super();
		dao = new ThreadDao();
		commentdao = new CommentDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		/*if (action.equalsIgnoreCase("delete")) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			dao.deleteUser(userId);
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else*/ if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			/*int userId = Integer.parseInt(request.getParameter("userId"));
			User user = dao.getUserById(userId);
			request.setAttribute("user", user);*/
			
			//take in the thread id of the thing you are entering
			//using this id make a sql of the comments that correspond to the id
			//display comments on page
			
			int threadId = Integer.parseInt(request.getParameter("ThreadID"));
			System.out.print(threadId);
			request.setAttribute("comments", commentdao.getAllComments(threadId));
		
			
			
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			request.setAttribute("threads", dao.getAllThreads());
		} /*else {
			forward = INSERT_OR_EDIT;
		}*/

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
	//BRAINSTORMING FOR ADDING A COMMENT
	//add in the textarea to take in the appropriate input and send to usercontroller (done)
	//make sure on submit, the thread will also send in the threadID (not done)
	//modify this doPost to make it for posting a comment
	//have it take in getParameter("Comment") and do like comment.setComment
	//and then do Comment dao.addComment()
	//code the CommentDao to have this command
	//the command should take in the parameter as a string, and the thread that the user is currently on
	//the commmand will do some SQL like INSERT comment to Comments WHERE threadid=id

	/*protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		try {
			Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request
					.getParameter("dob"));
			user.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setEmail(request.getParameter("email"));
		String userid = request.getParameter("userid");
		if (userid == null || userid.isEmpty()) {
			dao.addUser(user);
		} else {
			user.setUserid(Integer.parseInt(userid));
			dao.updateUser(user);
		}
		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
		request.setAttribute("users", dao.getAllUsers());
		view.forward(request, response);
	}*/
}