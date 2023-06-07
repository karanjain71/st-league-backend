package com.stocks.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.stocks.db1.entities.ContestDetails;
import com.stocks.db1.entities.User;
import com.stocks.db1.repositories.ContestRepository;
import com.stocks.services.ContestService;

public class ContestServiceImpl implements ContestService{

	@Autowired
	ContestRepository contestRepository;
	
	@Override
	public void createContestPublic(@RequestBody ContestDetails contest) {
		contestRepository.save(contest);
	}

	@Override
	public void createContestPrivate(@RequestBody ContestDetails contest) {
		contestRepository.save(contest);
	}

	@Override
	public void joinContest(User user, String contestCode) {
	
		
	}

	@Override
	public void getContestDetails(String contestCode) {

		
	}

	@Override
	public void updateContestDetails(ContestDetails contest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelContest(ContestDetails contest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> updateLeaderboard(String contestCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getWinners(String contestCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAllContests() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void myContests() {
		// TODO Auto-generated method stub
		
	}

}
