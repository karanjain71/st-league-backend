package com.stocks.db1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocks.db1.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
    User findByUserNameOrEmail(String username, String email);
    User findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    User findByPasswordResetToken(String token);
    //List<User> findAll();
	
	
}
