package com.stocks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.db2.entities.StockTicker;
import com.stocks.db2.repositories.StockTickerRepository;

@RestController
@RequestMapping("/api/v1/stockTicker")
public class StockTickerController {

	@Autowired
	private StockTickerRepository stockTickerRepository;
	
	@GetMapping
	List<StockTicker> getData(){  
		return stockTickerRepository.findAll();
	}
	
	@PostMapping
	List<StockTicker> addData(@RequestBody List<StockTicker> data){  
		return stockTickerRepository.saveAll(data);
	}
	
	@GetMapping("/oneDayData")
	List<StockTicker> oneDayData(){
		return stockTickerRepository.oneDayDataList(null, null);
		
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
