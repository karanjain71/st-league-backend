package com.stocks.db1.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stocks.db1.entities.ContestDetails;
import com.stocks.db1.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
    User findByUserNameOrEmail(String username, String email);
    User findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);
    User findByPasswordResetToken(String token);
    //List<User> findAll();
    
    @Query(value = "SELECT c.userContests from user c WHERE c.email = :email ", nativeQuery = true)
    Set<ContestDetails> getUserContests(@Param("email") String email);
	
	
}
