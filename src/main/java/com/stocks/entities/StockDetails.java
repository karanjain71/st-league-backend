package com.stocks.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
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
	
	@Column(name="company_name", nullable = false)
	public String CompanyName;
	
	@Column(name="market_cap", nullable = false)
	public double MarketCap;
	
	@Column(name="nse_code", nullable = false)
	public String NSECode;
	
	@Column(name="today_open", nullable = false)
	public double TodayOpen;
	
	@Column(name="today_high", nullable = false)
	public double TodayHigh;
	
	@Column(name="today_low", nullable = false)
	public double TodayLow;
	
	@Column(name="today_close", nullable = false)
	public double TodayClose;
	
	@Column(name="ltp", nullable = false)
	public double ltp;
	
	@Column(name="day_change", nullable = false)
	public double dayChange;
	
	@Column(name="day_change_per_c", nullable = false)
	public double dayChangePerc;
	
	@Column(name="volume", nullable = false)
	public long volume;
	
	@Column(name="tot_buy_qty", nullable = false)
	public long totalBuyQty;
	
	@Column(name="tot_sell_qty", nullable = false)
	public long totalSellQty;
	
	@Column(name="yr_high", nullable = false)
	public double YrHigh;
	
	@Column(name="yr_low", nullable = false)
	public double YrLow;
	
}
