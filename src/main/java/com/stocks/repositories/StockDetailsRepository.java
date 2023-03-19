package com.stocks.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stocks.entities.StockDetails;

@Repository
public interface StockDetailsRepository extends JpaRepository<StockDetails, Integer> {

	@Query(value = "Select * from stock_details where nsecode = :nsecode", nativeQuery = true)
	Optional<StockDetails> findByNseCode(@Param("nsecode") String nsecode);
	
}
