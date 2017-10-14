package com.loginForm.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.loginForm.model.userModel;

public class registerUserToDB {

	public boolean register_user(userModel model)
	{	
		Boolean res = false;
		
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost:3306/todoDB";
				Connection conn = DriverManager.getConnection(url,"root","root");
				
				String query = "insert into userInfo (userId, userName, userEmail, password, MobileNo) values (?, ?, ?, ?, ?)"; 
				String fullname = model.getrFirst_name()+model.getrLast_name();
				
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, model.getrFirst_name());
				ps.setString(2, fullname);
				ps.setString(3, model.getrEmail());
				ps.setString(4, model.getrPassword());
				ps.setString(5, model.getrMno());
				ps.execute();
				conn.close();
				System.out.println("register succefully");
				res = true;
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error at register_user :"+e);
			}
			
		return res;
	}

}
