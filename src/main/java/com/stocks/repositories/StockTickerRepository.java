package com.stocks.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stocks.entities.StockTicker;

public interface StockTickerRepository extends JpaRepository<StockTicker, Long>{

	@Query(value = "SELECT t from stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) = :date ", nativeQuery = true)
	List<StockTicker> oneDayDataList(@Param("date") LocalDate date, @Param("companyCode") String companyCode);
	
	@Query(value = "SELECT t from stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) >= :date ", nativeQuery = true)
	List<StockTicker> fiveDayDataList(@Param("date") LocalDate date, @Param("companyCode") String companyCode);
	
	@Query(value = "SELECT t FROM stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) >= :date AND TIME(t.date) = TIME(15:30:00)  ", nativeQuery = true)
	List<StockTicker> oneMonthDataList(@Param("date") LocalDate lastMonth, @Param("companyCode") String companyCode);
	
	@Query(value = "SELECT t from stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) >= :date AND TIME(t.date) = TIME(15:30:00) ", nativeQuery = true)
	List<StockTicker> sixMonthDataList(@Param("date") LocalDate date, @Param("companyCode") String companyCode);
	
	@Query(value = "SELECT t from stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) >= :date AND TIME(t.date) = TIME(15:30:00) ", nativeQuery = true)
	List<StockTicker> oneYearDataList(@Param("date") LocalDate date, @Param("companyCode") String companyCode);
	
	@Query(value = "SELECT t from stock_ticker t WHERE t.companyCode = :companyCode AND DATE(t.date) >= :date AND TIME(t.date) = TIME(15:30:00) AND MOD(DATE(t.date), 7) = 0 ", nativeQuery = true)
	List<StockTicker> fiveYearDataList(@Param("date") LocalDate date, @Param("companyCode") String companyCode);
}
//SELECT t FROM stock_ticker t WHERE t.date = ( SELECT MAX(t.date) FROM stock_ticker WHERE DATE(t.date) >= lastMonth GROUP BY DATE(t.date))