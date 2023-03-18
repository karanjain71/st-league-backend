package com.stocks.services.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonValue;
import com.stocks.entities.StockDetails;
import com.stocks.repositories.StockDetailsRepository;
import com.stocks.services.StockDetailsService;

@Service
public class StockDetailsServiceImpl implements StockDetailsService{

	@Autowired
	private StockDetailsRepository stockDetailsRepository;

	@Override
	public List<StockDetails> getAllStockDetails() {
		
		try {
			System.out.println("coming here inside");
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					  .uri(new URI("https://api.stockmarketapi.in/api/v1/allstocks?token=fd4c700750586431649973e43647278c2b24d495052a8ce66358eb576b8912c8"))
					  .GET()
					  .build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String responseBody = response.body();
//			Object obj = JsonValue.parse(responseBody);
			
//			for(int i=0;i<responseBody)
			System.out.println("type is " + responseBody.getClass().getName());
			int responseStatus = response.statusCode();
//			System.out.println(responseBody + " responseBody");
			System.out.println(responseStatus + " status");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		return null;
	}

	@Override
	public StockDetails getStockDetailsById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
//	@Override
//	public List<StockDetails> getAllStockDetails() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}
