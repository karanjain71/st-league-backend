package com.stocks.serviceImpl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.stocks.configs.StockDetailsConstants;
import com.stocks.entities.StockDetails;
import com.stocks.payloads.AllStocksApiResponse;
import com.stocks.repositories.StockDetailsRepository;
import com.stocks.services.StockDetailsService;

@Service
public class StockDetailsServiceImpl implements StockDetailsService{

	@Autowired
	private StockDetailsRepository stockDetailsRepository;
	
	@Override
	public List<StockDetails> getAllStockDetails() {
		
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					  .uri(new URI(StockDetailsConstants.STOCK_API_URL + "/api/v1/allstocks?token=" + StockDetailsConstants.STOCK_API_KEY))
					  .GET()
					  .build();
			
			var response = client.send(request,BodyHandlers.ofString());
			System.out.println("Api succeeded here!!");
			
            AllStocksApiResponse obj = new Gson().fromJson(response.body(), AllStocksApiResponse.class);
            
            
            for(StockDetails st: obj.getData()) {
            	StockDetails stockCheck = stockDetailsRepository.findByNseCode(st.getNSECode()).orElse(new StockDetails());
            	if(stockCheck.getNSECode()!="") {
            		System.out.println("company already present in the db. just update stock");
            		updateStockDetails(st.getNSECode(), st);
            		
            	}
            	else {        
            		System.out.println("Adding the new stock here");
            		addStockDetails(st);
            	}
            }			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public StockDetails getStockDetailsByNseCode(String nsecode) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public StockDetails addStockDetails(StockDetails st) {
		StockDetails addedStock = stockDetailsRepository.save(st);
		return addedStock;
	}
	
	@Override
	public StockDetails updateStockDetails(String nsecode, StockDetails st) {
		StockDetails updatedStock = stockDetailsRepository.findByNseCode(st.getNSECode()).orElse(new StockDetails());
		if(updatedStock.getNSECode()!="") {
    		System.out.println("company already present in the db. just update stock");
    		updatedStock.setCompanyName(st.getCompanyName());
    		updatedStock.setMarketCap(st.getMarketCap());
    		updatedStock.setTodayClose(st.getTodayClose());
    		updatedStock.setTodayHigh(st.getTodayHigh());
    		updatedStock.setTodayLow(st.getTodayLow());
    		updatedStock.setTodayOpen(st.getTodayOpen());
    		updatedStock.setLtp(st.getLtp());
    		updatedStock.setDayChange(st.getDayChange());
    		updatedStock.setDayChangePerc(st.getDayChangePerc());
    		updatedStock.setVolume(st.getVolume());
    		updatedStock.setYrHigh(st.getYrHigh());
    		updatedStock.setYrLow(st.getYrLow());
    		addStockDetails(updatedStock);	
    	}
		return updatedStock;
	}
	
	
}
