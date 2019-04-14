package com.mendonca.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mendonca.model.User;
import com.mendonca.repository.UserRepository;
import com.mendonca.services.UserService;



@Controller
public class AplicationController {

	@Autowired
	private UserService  userService;
	
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request){
		request.setAttribute("mode","MODE_REGISTER");
		
		return "welcomepage";
	}
	
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest request){
		request.setAttribute("mode","MODE_REGISTER");
		
		return "welcomepage";
	}
	
	
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult,HttpServletRequest request ){
		
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		
		return "welcomepage";
	}
	
	
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request){
		request.setAttribute("users",userService.showAllUsers() );
		request.setAttribute("mode","ALL_USERS" );
		return "welcomepage";
	}
	
	
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id,HttpServletRequest request){
	userService.deleteMyUser(id);
	request.setAttribute("users",userService.showAllUsers() );
	request.setAttribute("mode","ALL_USERS" );
	return "welcomepage";
		
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request){
	
	request.setAttribute("user", userService.editUser(id));
			
	request.setAttribute("mode","MODE_UPDATE");	
	return "welcomepage";
	}
	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request){
		
	request.setAttribute("mode","MODE_LOGIN");	
	return "welcomepage";	
	}
	
	
	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, HttpServletRequest request){
	
	if(userService.findUsernameAndPassword(user.getUsername(),user.getPassword()) != null ){
		return "homepage";
	}else{
		
		request.setAttribute("erro","invalid Username or Password ");
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}	
			
	
	}
	
	
	
}
