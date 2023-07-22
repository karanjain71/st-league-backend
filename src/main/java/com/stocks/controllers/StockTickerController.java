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
	
	@PostMapping
	StockTicker addData(@RequestBody StockTicker stockTicker) {
		System.out.println(stockTicker.getClose());
		stockTickerRepository.save(stockTicker);
		return null;
	}
	
	@GetMapping("/oneDayData")
	List<StockTicker> oneDayData(){
		try {
			List<StockTicker> st = stockTickerRepository.findAll();
			System.out.println(st.size());
			return st;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
		
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
