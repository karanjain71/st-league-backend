package com.stocks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.entities.StockTicker;
import com.stocks.repositories.StockTickerRepository;

@RestController
@RequestMapping("/api/v1/stockTicker")
public class StockTickerController {

	private StockTickerRepository stockTickerRepository;
	
	@GetMapping("/oneDayData")
	List<StockTicker> oneDayData(){
		return null;
		
	}
	
	@GetMapping("/fiveDayData")
	List<StockTicker> fiveDayData(){
		return null;
		
	}
	
	@GetMapping("/oneMonthData")
	List<StockTicker> oneMonthData(){
		return null;
		
	}
	
	@GetMapping("/sixMonthData")
	List<StockTicker> sixMonthData(){
		return null;
		
	}
	
	@GetMapping("/oneYearData")
	List<StockTicker> oneYearData(){
		return null;
		
	}
	
	@GetMapping("/fiveYearData")
	List<StockTicker> fiveYearData(){
		return null;
		
	}
	
}
