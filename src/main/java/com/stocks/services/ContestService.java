package com.stocks.services;

import java.util.List;

import com.stocks.db1.entities.ContestDetails;
import com.stocks.db1.entities.User;

public interface ContestService {

	void createContestPublic(ContestDetails contest);
	void createContestPrivate(ContestDetails contest);
	void joinContest(User user, String contestCode);
	void getContestDetails(String contestCode);
	void updateContestDetails(ContestDetails contest);
	void cancelContest(ContestDetails contest);
	//List<User> getParticipants(String contestCode);
	List<User> updateLeaderboard(String contestCode);
	List<User> getWinners(String contestCode);
	void getAllContests();
	void myContests();
	
	
	
}
