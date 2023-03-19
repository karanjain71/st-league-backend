package com.stocks.services;

import java.util.List;

import com.stocks.entities.StockDetails;

public interface StockDetailsService {

	
	StockDetails addStockDetails(StockDetails stockDetails); 
	StockDetails updateStockDetails(String nsecode, StockDetails st);
	StockDetails getStockDetailsByNseCode(String nsecode);
	List<StockDetails> getAllStockDetails();
	
	
}
