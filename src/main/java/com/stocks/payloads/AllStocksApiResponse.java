package com.stocks.payloads;

import java.util.List;

import com.stocks.entities.StockDetails;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AllStocksApiResponse {
	private int status;
	private List<StockDetails> data;
	
}
