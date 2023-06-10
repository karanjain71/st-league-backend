package com.stocks.db1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stocks.db1.entities.PointsTable;

public interface PointsTableRepository extends JpaRepository<PointsTable, Long> {

	@Query(value = "SELECT p.user_id, p.points FROM points_table p WHERE p.contest_id = :contestId ORDER BY p.points DSC", nativeQuery = true)
	List<Object[]> getLeaderboard(@Param("contestId") String contestId);
    
}
