package com.stocks.db1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	User userId;
	
	@ManyToOne
    @JoinColumn(name = "contest_id")
	ContestDetails contestId;
	
	@Column(name = "points")
	Double points;
}
