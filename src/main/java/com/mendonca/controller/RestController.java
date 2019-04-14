package com.mendonca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mendonca.model.User;
import com.mendonca.services.UserService;




@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserService userService;
	
	
@GetMapping("/")	
public String hello(){
	return "this is Home page";
}	
	

@GetMapping("/saveuser")
public String saveUser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname,@RequestParam int age,@RequestParam String password ){
	
User user = new User(username,firstname,lastname,age,password);	
userService.saveMyUser(user);	
	
	return "user Saved";
}





//SETs and Gets
public UserService getUserService() {
	return userService;
}


public void setUserService(UserService userService) {
	this.userService = userService;
}
	
	





	
}
