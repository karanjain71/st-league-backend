package com.stocks.db1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocks.db1.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Optional<Role> findByName(String name);
}
