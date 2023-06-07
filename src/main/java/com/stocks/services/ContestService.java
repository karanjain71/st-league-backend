package com.stocks.services;

import java.util.List;

import com.stocks.db1.entities.ContestDetails;
import com.stocks.db1.entities.User;

public interface ContestService {

	void createContest(ContestDetails contest);
	void joinContest(User user, ContestDetails contestCode);
	void getContestDetails(String contestCode);
	ContestDetails updateContestDetails(ContestDetails contest);
	void cancelContest(ContestDetails contest);
	//List<User> getParticipants(String contestCode);
	List<User> updateLeaderboard(String contestCode);
	List<User> getWinners(String contestCode);
	void getAllContests();
	void myContests();
	
	
	
}
