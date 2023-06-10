package com.stocks.db1.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "points_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PointsTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	User user_id;
	
	ContestDetails contest_id;
	
	@Column(name = "points")
	Double points;
}
