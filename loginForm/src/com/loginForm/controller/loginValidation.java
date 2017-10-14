package com.loginForm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loginForm.Dao.userValidation;
import com.loginForm.model.userModel;

/**
 * Servlet implementation class loginValidation
 */

public class loginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	userModel model = new userModel();
	userValidation uv = new userValidation();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do post called");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		model.setrEmail(username);
		model.setrPassword(password);
	
		if(uv.valid_user(model))
		{
			System.out.println("login succefully");
			
			//save user to session
			HttpSession session = request.getSession(true);
			session.setAttribute("login_username", model.getrFirst_name());
			System.out.println("user = "+model.getrFirst_name());
			request.getRequestDispatcher("/homepage.jsp").forward(request, response);
		}
		else
		{
			System.out.println("login unsuccefully");
			out.println("<b><font color=\"red\">Invalid Login..!!</font></b><br>");
			request.getRequestDispatcher("/signUp.html").include(request, response);
		}
	}

	

}
