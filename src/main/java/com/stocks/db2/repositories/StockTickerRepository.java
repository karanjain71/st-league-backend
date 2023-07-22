package com.stocks.db2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stocks.db2.entities.StockTicker;

public interface StockTickerRepository extends MongoRepository<StockTicker, Long>{

//	@Query(value = "SELECT t from stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) = :date ", nativeQuery = true)
//	List<StockTicker> oneDayDataList(@Param("date") LocalDate date, @Param("companyCode") String companyCode);
//	
//	@Query(value = "SELECT t from stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) >= :date ", nativeQuery = true)
//	List<StockTicker> fiveDayDataList(@Param("date") LocalDate date, @Param("companyCode") String companyCode);
//	
//	@Query(value = "SELECT t FROM stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) >= :date AND TIME(t.date) = TIME(15:30:00)  ", nativeQuery = true)
//	List<StockTicker> oneMonthDataList(@Param("date") LocalDate lastMonth, @Param("companyCode") String companyCode);
//	
//	@Query(value = "SELECT t from stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) >= :date AND TIME(t.date) = TIME(15:30:00) ", nativeQuery = true)
//	List<StockTicker> sixMonthDataList(@Param("date") LocalDate date, @Param("companyCode") String companyCode);
//	
//	@Query(value = "SELECT t from stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) >= :date AND TIME(t.date) = TIME(15:30:00) ", nativeQuery = true)
//	List<StockTicker> oneYearDataList(@Param("date") LocalDate date, @Param("companyCode") String companyCode);
//	
//	@Query(value = "SELECT t from stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) >= :date AND TIME(t.date) = TIME(15:30:00) AND MOD(DATE(t.date), 7) = 0 ", nativeQuery = true)
//	List<StockTicker> fiveYearDataList(@Param("date") LocalDate date, @Param("companyCode") String companyCode);
}
//SELECT t FROM stock_ticker t WHERE t.date = ( SELECT MAX(t.date) FROM stock_ticker WHERE DATE(t.date) >= lastMonth GROUP BY DATE(t.date))