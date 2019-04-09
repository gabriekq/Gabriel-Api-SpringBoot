package com.mendonca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class AplicationController {

	@ResponseBody
	@RequestMapping("/home")
	public String Hello(){
		
		return "Hello from Spring";
	}
	
	
	@RequestMapping("/welcome")
	public String Welcome(){
		return "welcomepage";
	}
	
	
	
	
}
