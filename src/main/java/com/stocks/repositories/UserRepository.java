package com.stocks.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocks.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}
