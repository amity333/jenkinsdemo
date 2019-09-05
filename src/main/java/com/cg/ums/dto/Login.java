package com.cg.ums.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cg_users")
public class Login 
{
	
	@NotEmpty(message="UserName is  Mandatory")
	@Id
	@Column(name="user_name",length=15)
	private String userName;
	
	@NotEmpty(message="Password is  Mandatory")
	@Column(name="password",length=20)
	private String userPass;
	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getUserPass() 
	{
		return userPass;
	}
	
	public void setUserPass(String userPass) 
	{
		this.userPass = userPass;
	}
	
	@Override
	public String toString() 
	{
		return "Login [userName=" + userName + ", userPass=" + userPass + "]";
	}
	
	public Login() 
	{
		super();
	}
	
	public Login(String userName, String userPass) 
	{
		super();
		this.userName = userName;
		this.userPass = userPass;
	}
}
