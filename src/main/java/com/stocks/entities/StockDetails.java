package com.stocks.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="stock_details")
@Setter
@Getter
public class StockDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	public String CompanyName;
	public double MarketCap;
	public String NSECode;
	public double TodayOpen;
	public double TodayHigh;
	public double TodayLow;
	public double TodayClose;
	public double ltp;
	public double dayChange;
	public double dayChangePerc;
	public long volume;
	public long totalBuyQty;
	public long totalSellQty;
	public double YrHigh;
	public double YrLow;
	
}
