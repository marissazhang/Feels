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
import com.mie.model.Comment;


//TODO
// 1. get the right comments page to display after adding a comment
//2. add functionality to create a thread
// 3. add functionality to delete a comment
// 4. adding in functionality to post anonymously?


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW = "/thread.jsp";
	private static String LIST_USER = "/forum.jsp";
	private static String LIST_COMMENTS = "/thread.jsp";
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
		} else*/ if (action.equalsIgnoreCase("view")) {
			forward = VIEW;
			/*int userId = Integer.parseInt(request.getParameter("userId"));
			User user = dao.getUserById(userId);
			request.setAttribute("user", user);*/
			
			//take in the thread id of the thing you are entering
			//using this id make a sql of the comments that correspond to the id
			//display comments on page
			
			int threadId = Integer.parseInt(request.getParameter("ThreadID"));
			System.out.println(threadId);
			request.setAttribute("comments", commentdao.getAllComments(threadId));
		
		
			
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			request.setAttribute("threads", dao.getAllThreads());
			
		} else if (action.equalsIgnoreCase("insertThread")) {
			forward = "/newThread.jsp";
		}
		

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Comment comment = new Comment();
		//setting thread
		String threadid = request.getParameter("ThreadID");
		comment.setThreadID(Integer.parseInt(threadid));

		//setting userid
		String userid = request.getParameter("UserID");
		comment.setUserID(Integer.parseInt(userid));
		
		//set comment
		comment.setComment(request.getParameter("Comment"));
		
		//add to dao
		commentdao.addComment(comment);

		//TODO: figure out a way to take it back to the current comments page
		RequestDispatcher view = request.getRequestDispatcher(VIEW);
		request.setAttribute("threads", dao.getAllThreads());
		view.forward(request, response);
		
	}
}