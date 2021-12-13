package com.git.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.git.dataaccesslayer.entity.User;
import com.git.userservice.exception.UserAlreadyExistException;
import com.git.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public String saveUser(@RequestBody User user) {
		try {
		 userService.saveUser(user);
		}catch (UserAlreadyExistException e) {
			return "User already exists";
		}
		return "User created";
	}
}
