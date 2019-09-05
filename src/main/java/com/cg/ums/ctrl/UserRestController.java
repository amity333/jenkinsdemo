package com.cg.ums.ctrl;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ums.dto.Login;
import com.cg.ums.service.ILoginService;

@RestController
public class UserRestController 
{
	@Autowired
	ILoginService logSer;
	
	@RequestMapping(value="/showAllUsers", method=RequestMethod.GET,headers="Accept=application/json")
	public ArrayList<Login> showAllUsers()
	{
		System.out.println("---UserRestController showAllUsers called");
		return logSer.getAllUsers();
	}
	
	/***********************************************************/
	
	@PostMapping(value="/addUser",consumes=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	public Login createUser(@RequestBody Login log)
	{
		logSer.addUser(log);
		Login lgg = logSer.getUserByUserName(log.getUserName());
		return lgg;	
	}
	
	
	@DeleteMapping(value="/deleteUser/{uid}",headers="Accept=application/json")
	public String deletUser(@PathVariable("uid") String unm)
	{
		logSer.deleteUserByUserName(unm);
		return ("data deleted...");
	}
	
	
	@PutMapping(value="/user/update",consumes=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public void updateUser(@RequestBody Login lg)
	{
		logSer.updateUserInfo(lg.getUserPass(), lg.getUserName());
		System.out.println("data updated in the table..........");
	}
	

}
