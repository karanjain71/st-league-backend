package com.stocks.db1.entities;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContestDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(name="contest_code", nullable = false)
	String conCode;
	
	@Column(name="contest_name", nullable = false)
	String conName;
	
	@Column(name="start_time", nullable = false)
	LocalDateTime conStartTime;
	
	@Column(name="end_time", nullable = false)
	LocalDateTime conEndTime;
	
	@Column(name="prize_pool", nullable = false)
	Long prizePool;
	
	@Column(name="entry_fee", nullable = false)
	Long entryFee;
	
	@Column(name="tot_spots", nullable = false)
	Long totalSpots;
	
	@Column(name="avail_spots", nullable = false)
	Long availableSpots;
	
	@Column(name="status", nullable = false)
	String conStatus;
	
	@Column(name="type", nullable = false)
	String conType;
	
	Map<String, Long>winnerPrize;
	
	Set<User>contestUsers;
	
}
