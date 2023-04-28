package com.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocks.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
    User findByUserNameOrEmail(String username, String email);
    User findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    User findByPasswordResetToken(String token);
	
	
}
