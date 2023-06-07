package com.stocks.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
	public void createContest(@RequestBody ContestDetails contest) {
		contestRepository.save(contest);
	}

	@Override
	public void joinContest(User user, ContestDetails contest) {
		contest.getContestUsers().add(user);
		
	}

	@Override
	public void getContestDetails(String contestCode) {
		contestRepository.findByConCode(contestCode);
		
	}

	@Override
	public ContestDetails updateContestDetails(ContestDetails contest) {
		Optional<ContestDetails> existingContest = contestRepository.findById(contest.getId());
        if (existingContest.isEmpty()) {
            throw new NoSuchElementException("Contest not found");
        }
        ContestDetails oldContest = existingContest.get();
        BeanUtils.copyProperties(contest, oldContest);
        ContestDetails savedContest = contestRepository.save(oldContest);
        return savedContest;
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
