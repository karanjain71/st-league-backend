package com.stocks.services;

import java.util.List;
import java.util.Set;

import com.stocks.db1.entities.ContestDetails;
import com.stocks.db1.entities.User;

public interface ContestService {

	void createContest(ContestDetails contest);
	void joinContest(User user, ContestDetails contestCode);
	void getContestDetails(String contestCode);
	ContestDetails updateContestDetails(ContestDetails contest);
	ContestDetails cancelContest(ContestDetails contest);
	List<Object[]> getLeaderboard(String contestCode);
	List<Object[]> setWinners(ContestDetails contestCode);
	List<ContestDetails> getAllContests();
	Set<ContestDetails> myContests(User user);
	//void addUpdateWinnningPrizeMap();
	
	
	
}
