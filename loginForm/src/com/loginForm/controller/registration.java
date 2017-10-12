package com.loginForm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loginForm.Dao.registerUserToDB;
import com.loginForm.model.userModel;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMessages;


public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    userModel model = new userModel(); 
    registerUserToDB robj = new registerUserToDB();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		
		String f_name = request.getParameter("first");
		String l_name = request.getParameter("last");
		model.setFirst_name(f_name+l_name);
		model.setEmail(request.getParameter("email"));
		model.setPassword(request.getParameter("password"));
		model.setMobile_no(request.getParameter("Mno"));
		
		if(robj.register_user(model))
		{
			pw.println("registered");
			request.getRequestDispatcher("/signUp.html").forward(request, response);
		}
		else
		{
			
			pw.println("<script>");
			pw.println("document.getElementById('error').innerText=Sorry UserName or Password Error");
			pw.println("<script>");
			request.getRequestDispatcher("/registration.html").include(request, response);
		}
		
	}

	
	

}
