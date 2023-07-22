package com.stocks.db2.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "stock_ticker")
@Getter
@Setter
public class StockTicker {

	@Id
	public String id;
	
	@Column(name="date")
	public LocalDateTime date;
	
	@Column(name="company_name", nullable = false)
	public String companyName;
	
	@Column(name="company_code", nullable = false)
	public String companyCode;
	
	@Column(name="ltp", nullable = false)
	public double ltp;
	
	@Column(name="open", nullable = false)
	public double open;
	
	@Column(name="close", nullable = false)
	public double close;
	
	@Column(name="high", nullable = false)
	public double high;
	
	@Column(name="low", nullable = false)
	public double low;
	
	@Column(name="volume", nullable = false)
	public long volume;
	

}
