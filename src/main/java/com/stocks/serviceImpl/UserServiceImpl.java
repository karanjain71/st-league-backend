package com.stocks.serviceImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.entities.User;
import com.stocks.repositories.UserRepository;
import com.stocks.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user, String userEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgotPassword(String email) {
		Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));

		if (!userOptional.isPresent()) {
			return "Invalid email id!";
		}

		User user = userOptional.get();
		user.setPasswordResetToken(generateToken());
		user.setTokenCreationDate(LocalDateTime.now());

		user = userRepository.save(user);

		return user.getPasswordResetToken();
	}

	@Override
	public String resetPassword(String token, String password) {
		Optional<User> userOptional = Optional.ofNullable(userRepository.findByPasswordResetToken(token));

		if (!userOptional.isPresent()) {
			return "Invalid token!";
		}

		LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

		if (isTokenExpired(tokenCreationDate)) {
			return "Token expired!";

		}

		User user = userOptional.get();

		user.setPassword(password);
		user.setPasswordResetToken(null);
		user.setTokenCreationDate(null);

		userRepository.save(user);

		return "Your password updated successfully!";
	}

	@Override
	public String generateToken() {
		StringBuilder token = new StringBuilder();

		return token.append(UUID.randomUUID().toString()).append(UUID.randomUUID().toString()).toString();
	}

	@Override
	public boolean isTokenExpired(LocalDateTime tokenCreationDate) {
		LocalDateTime now = LocalDateTime.now();
		Duration diff = Duration.between(tokenCreationDate, now);

		return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
	}
	
	
	
}
