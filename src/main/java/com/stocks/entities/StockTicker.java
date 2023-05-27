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
@Table(name="stock_ticker")
@Setter
@Getter
public class StockTicker {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@Column(name="date", nullable = false)
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
