package com.stocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocks.entities.StockDetails;

@Repository
public interface StockDetailsRepository extends JpaRepository<StockDetails, Integer> {

}
