package com.stocks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.db1.entities.StockDetails;
import com.stocks.db1.repositories.StockDetailsRepository;
import com.stocks.payloads.AllStocksApiResponse;
import com.stocks.services.StockDetailsService;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockDetailsController {
	
	@Autowired
	private StockDetailsService stockDetailsService;
	
	@GetMapping
	public List<StockDetails> getAllStocks() {
		System.out.println("Getting All Stocks");
		return stockDetailsService.getAllStockDetails();
	}
	
	@PostMapping("/getStockDetail")
	public StockDetails getStockDetail(@RequestParam String nseCode) {
		System.out.println("Getting Stock Details");
		return stockDetailsService.getStockDetailsByNseCode(nseCode);
	}
	
	@GetMapping("/getTopGainers")
	public AllStocksApiResponse getTopGainers() {
		System.out.println("Getting Top Gainers");
		return stockDetailsService.getTopGainers();
	}
	
	@GetMapping("/getTopLosers")
	public AllStocksApiResponse getTopLosers() {
		System.out.println("Getting Top Losers");
		return stockDetailsService.getTopLosers();
	}
	
	@GetMapping("/getTopByVolume")
	public AllStocksApiResponse getTopByVolume() {
		System.out.println("Getting Top Stocks By Volume");
		return stockDetailsService.getTopStocksByVolume();
	}
	
}
