package com.loginForm.model;

public class userModel {
	
	//getter-setter files..,
	public userModel() {
		// TODO Auto-generated constructor stub
		//set initial value
	}
	
	private String First_name;
	private String last_name;
	private String Email;
	private String Password;
	private String Mno;
	
	//set value for first name
	public void setFirst_name(String First_name) 
	{
		this.First_name = First_name;
	}
	//get value for first name
	public String getFirst_name() 
	{
		return (this.First_name);
	}
	
	//set value for last name
	public void setlast_name(String last_name) 
	{
		this.last_name = last_name;
	}
	//get value for last name
	public String getlast_name() 
	{
		return (this.last_name);
	}
	
	//set value for email
	public void setEmail(String Email) 
	{
		this.Email = Email;
	}
	//get value for email
	public String getEmail() 
	{
		return (this.Email);
	}

	//set value for password
	public void setPassword(String Password) 
	{
		this.Password = Password;
	}
	//get value for password
	public String getPassword() 
	{
		return (this.Password);
	}

	//set value for mobile no
	public void setMobile_no(String Mno) 
	{
		this.Mno = Mno;
	}
	//get value for mobile no
	public String getMobile_no() 
	{
		return (this.Mno);
	}

}
