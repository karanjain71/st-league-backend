package com.stocks.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.stocks.db1.entities.ContestDetails;
import com.stocks.db1.entities.User;
import com.stocks.db1.repositories.ContestRepository;
import com.stocks.db1.repositories.PointsTableRepository;
import com.stocks.db1.repositories.UserRepository;
import com.stocks.services.ContestService;

public class ContestServiceImpl implements ContestService{

	@Autowired
	ContestRepository contestRepository;
	UserRepository userRepository;
	PointsTableRepository pointsTableRepository; 
	
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
	public ContestDetails cancelContest(ContestDetails contest) {
		Optional<ContestDetails> existingContest = contestRepository.findById(contest.getId());
        if (existingContest.isEmpty()) {
            throw new NoSuchElementException("Contest not found");
        }
        ContestDetails canContest = existingContest.get();
        canContest.setConStatus("Cancelled");
        ContestDetails savedContest = contestRepository.save(canContest);
        
        return savedContest;
		
	}

	@Override
	public List<Object[]> getLeaderboard(String contestCode) {
		return pointsTableRepository.getLeaderboard(contestCode);
	}

	@Override
	public List<User> setWinners(ContestDetails contest) {
		Map<String, Long> winningAmt = contest.getWinningPrize();
		List<Object[]> leaderboard = pointsTableRepository.getLeaderboard(contest.getConCode());
		Long i=0L, j=0L;
		for(Object[] obj : leaderboard) {
			
		}
		for(Map.Entry<String, Long> entry : winningAmt.entrySet()) {
			String startRank = entry.getKey().split("-")[0], endRank = entry.getKey().split("-")[1];
			
		}
		return null;
	}

	@Override
	public List<ContestDetails> getAllContests() {
		return contestRepository.findAll();
		
	}

	@Override
	public Set<ContestDetails> myContests(User user) {
		String email = user.getEmail();
		return userRepository.getUserContests(email);
		
	}

}
