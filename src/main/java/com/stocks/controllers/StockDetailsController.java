package com.stocks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.services.StockDetailsService;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockDetailsController {
	
	@Autowired
	private StockDetailsService stockDetailsService;
	
	@GetMapping
	public void getAllStocks() {
		stockDetailsService.getAllStockDetails();
	}
}
