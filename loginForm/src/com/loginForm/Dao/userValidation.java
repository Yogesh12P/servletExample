package com.loginForm.Dao;

import java.sql.*;

import com.loginForm.model.userModel;

public class userValidation {

	Connection conn;
	public userValidation() {
		// TODO Auto-generated constructor stub
		//intial connection for DB..,	
	}
	
	public boolean valid_user(userModel model)
	{
		Boolean res = false;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/todoDB";
				Connection conn = DriverManager.getConnection(url,"root","root");
				Statement stmt = conn.createStatement();
				
				

					String sql = "Select * from userInfo Where userEmail='" + model.getEmail() + "' and password='" + model.getPassword() + "'";	
					ResultSet rs = stmt.executeQuery(sql);
					//stmt.close();
					if(rs.next())
					{
						res = true;
						System.out.println(rs.getString(2));
						System.out.println("login succefully");
						
					}else
					{
						res = false;
						System.out.println("login fail");
					}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error during checking valid user ERROR: "+e);
			}
		
		
		return res;
	}
	

}
