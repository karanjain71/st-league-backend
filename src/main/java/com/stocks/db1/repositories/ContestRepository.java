package com.stocks.db1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocks.db1.entities.ContestDetails;

public interface ContestRepository extends JpaRepository<ContestDetails, Long>{

	ContestDetails findByConCode(String conCode);
}
