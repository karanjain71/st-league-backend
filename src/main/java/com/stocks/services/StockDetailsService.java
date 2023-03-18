package com.stocks.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stocks.entities.StockDetails;

public interface StockDetailsService {

	
//	StockDetails addStockDetails(); 
	StockDetails getStockDetailsById(Integer id);
	List<StockDetails> getAllStockDetails();
	
	
}
