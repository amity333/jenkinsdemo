package com.cg.ums.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/ums/sayhello")
public class HelloRestController 
{
	@GetMapping
	
	public String greetme()
	{
		return "welcome to rest controller";
	}

}
