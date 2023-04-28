package com.stocks.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.stocks.entities.User;

@Service
public interface UserService {

	List<User>getAllUsers();
	User addUser(@RequestBody User user);
	User updateUser(@RequestBody User user, String userEmail);
	String forgotPassword(String email);
	String resetPassword(String token, String password);
	String generateToken();
	boolean isTokenExpired(final LocalDateTime tokenCreationDate);
	
	
}
