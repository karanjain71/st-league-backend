package com.stocks.db2.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stocks.db2.entities.StockTicker;

@Repository
public interface StockTickerRepository extends MongoRepository<StockTicker, String>{

	@Query("{ 'companyCode' : ?1, 'date' : ?0 }")
	List<StockTicker> oneDayDataList(LocalDate date, String companyCode);
	
	//@Query("{ companyCode: ?1, date: { $gte: ?0} }")
	//List<StockTicker> fiveDayDataList(LocalDate date, String companyCode);
	
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

//@Query("{ 'companyCode': ?0, 'date': { $gte: ?1, $lt: ?2 } }")