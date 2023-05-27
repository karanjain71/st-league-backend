package com.stocks.services;

import java.time.LocalDate;
import java.util.List;

import com.stocks.entities.StockDetails;
import com.stocks.payloads.AllStocksApiResponse;

public interface StockDetailsService {

	
	StockDetails addStockDetails(StockDetails stockDetails); 
	StockDetails updateStockDetails(String nsecode, StockDetails st);
	StockDetails getStockDetailsByNseCode(String nsecode);
	List<StockDetails> getAllStockDetails();
	AllStocksApiResponse getTopGainers();
	AllStocksApiResponse getTopLosers();
	AllStocksApiResponse getTopStocksByVolume();
	void updateStockDbCron();
	
}
