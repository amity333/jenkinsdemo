package com.cg.ums.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.cg.ums.dto.Login;

@Service
public interface ILoginService 
{
	public ArrayList<Login> getAllUsers();
	
	public Login addUser(Login log);
	public Login getUserByUserName(String unm);
	public void deleteUserByUserName(String unm);
	public void updateUserInfo(String newpwd , String unm);

}
