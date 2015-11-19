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
import com.mie.model.Thread;
import com.mie.model.Comment;
import com.mie.dao.ResourceDao;
import com.mie.dao.SymptomDao;
import com.mie.dao.UserDao;
import com.mie.model.User;


//TODO
// 1. get the right comments page to display after adding a comment
// 2. add functionality to create a thread
// 3. add functionality to delete a comment
// 4. adding in functionality to post anonymously?


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW = "/thread.jsp";
	private static String LIST_FORUM = "/forum.jsp";
	private static String LIST_COMMENTS = "/thread.jsp";
	private ThreadDao threaddao;
	private CommentDao commentdao;

	//aadil and oghosas stuff
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
		threaddao = new ThreadDao();
		commentdao = new CommentDao();
		//aadil and oghosas stuff
		dao = new UserDao();
		dao2 = new SymptomDao();
		dao3 = new ResourceDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("view")) {
		forward = VIEW;
		
		int threadId = Integer.parseInt(request.getParameter("ThreadID"));
		commentdao.setCurrentThreadID(threadId);
		request.setAttribute("comments", commentdao.getAllComments(threadId));
			
		} else if (action.equalsIgnoreCase("listUser")) {
			//TODO marissa fix this listUser weird bit
			forward = LIST_FORUM;
			request.setAttribute("threads", threaddao.getAllThreads());
			
		} else if (action.equalsIgnoreCase("insertThread")) {
			forward = "/newThread.jsp";
		}

		//aadil and oghosas changes

				else if (action.equalsIgnoreCase("listUsers")) {
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
	

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("insertThread")) {
			
			//code for thread posting here
			Thread thread = new Thread();
			
			//set userid
			String userid = request.getParameter("UserID");
			thread.setUserID(Integer.parseInt(userid));
			
			//set title
			thread.setTitle(request.getParameter("Title"));
			
			//add to dao
			threaddao.addThread(thread);
			
	
		}
		
		else if (action.equalsIgnoreCase("insertComment")){
			Comment comment = new Comment();
			
			//setting thread
			int threadid = commentdao.getCurrentThreadID();
			comment.setThreadID(commentdao.getCurrentThreadID());
			
			
			/*String threadid = request.getParameter("ThreadID");
			System.out.println("jtgoijrrtgswtg");
			
			comment.setThreadID(Integer.parseInt(threadid));*/
	
			//setting userid
			String userid = request.getParameter("UserID");
			System.out.print(userid);
			System.out.print("bleh");
			comment.setUserID(Integer.parseInt(userid));
			
			//set comment
			System.out.print(request.getParameter("Comment"));
			System.out.print("bleh");
			comment.setComment(request.getParameter("Comment"));
			
			//add to dao
			commentdao.addComment(comment);
	

		}

			else if (action.equalsIgnoreCase("newUser")) {
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