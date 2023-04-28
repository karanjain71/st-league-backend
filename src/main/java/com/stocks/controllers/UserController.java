package com.stocks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.entities.User;
import com.stocks.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private  UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
		
		return userService.getAllUsers();
	}
	
}
