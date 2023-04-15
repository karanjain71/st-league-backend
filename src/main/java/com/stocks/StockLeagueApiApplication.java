package com.stocks;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockLeagueApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockLeagueApiApplication.class, args);
		System.out.println("Hello1");
	}
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper;
	}

}
