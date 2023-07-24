package com.stocks.db2.entities;

import java.time.LocalDate;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "stock_ticker")
@Getter
@Setter
public class StockTicker {

	@Id
	private String id;
	
	private LocalDate date;
	private String companyName;
	private String companyCode;
	private double ltp;
	private double open;
	private double close;
	private double high;
	private double low;
	private long volume;
	

}
