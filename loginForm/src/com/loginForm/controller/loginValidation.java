package com.loginForm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		model.setEmail(username);
		model.setPassword(password);
	
		if(uv.valid_user(model))
		{
			System.out.println("login succefully");
			
			//save user to cookies
			Cookie ck = new Cookie("user", username);
			response.addCookie(ck);
			request.getRequestDispatcher("/homePage.html").forward(request, response);
		}
		else
		{
			System.out.println("login unsuccefully");
			out.println("<b><font color=\"red\">Invalid Login..!!</font></b><br>");
			request.getRequestDispatcher("/signUp.html").include(request, response);
		}
	}

	

}
