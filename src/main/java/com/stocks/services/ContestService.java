package com.stocks.services;

import java.util.List;

import com.stocks.db1.entities.User;

public interface ContestService {

	void createContestPublic();
	void createContestPrivate();
	void joinContest();
	void getContestDetails();
	void updateContestDetails();
	void cancelContest();
	List<User> getParticipants();
	List<User> updateLeaderboard();
	List<User> getWinners();
	
}
