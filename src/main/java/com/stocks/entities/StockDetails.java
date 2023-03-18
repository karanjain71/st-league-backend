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
	
	public String companyName;
	public double marketCap;
	public String nseCode;
	public double todayOpen;
	public double todayHigh;
	public double todayLow;
	public double todayClose;
	public double ltp;
	public double dayChange;
	public double dayChangePerc;
	public long volume;
	public long totalBuyQty;
	public long totalSellQty;
	public double yrHigh;
	public double yrLow;
	
}
