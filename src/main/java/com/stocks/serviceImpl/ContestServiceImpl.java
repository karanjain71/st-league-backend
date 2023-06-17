package com.stocks.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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

	int lowerBound(List<Integer>L, int ls, int x) {
		
		int start = 0 , end = ls-1;
		
		while(start <= end) {
			int mid = start + (end-start+1)/2;
			int val = L.get(mid);
			if(val > x) {
				end = mid-1;
			}
			else {
				start = mid;
			}
		}
		
		return start;
	}
	
	int upperBound(List<Object[]>L, int ls, Double x) {
		
		int start = 0 , end = ls-1;
		
		while(start < end) {
			int mid = start + (end - start)/2;
			Object[] obj = L.get(mid);
			double val = (double) obj[1];
			if(val >= x) {
				start = mid + 1;
			}
			else {
				end=mid;
			}
		}
		
		return start;
	}
	
	@Override
	public LinkedList<User> setWinners(ContestDetails contest) {
		Map<Integer, Integer> winningAmt = contest.getWinningPrize();
		List<Integer> ranks = new ArrayList<>(winningAmt.keySet());
		int rankSize = ranks.size();
		
		List<Object[]> leaderboard = pointsTableRepository.getLeaderboard(contest.getConCode());
		
		int strtRank = 1, endRank = 0;
		int i,j,ls=leaderboard.size();
		for(i = 0; i < ls; i++) {
			Object[] obj = leaderboard.get(i);
			Long user_id =  (Long)obj[0];
			Double points = (Double)obj[1];
			
			// get the length of repeated values
			int uInd = upperBound(leaderboard,ls,points);
			Object[] indObj = leaderboard.get(uInd);
			Double indPoints = (Double) indObj[1];
			if(indPoints == points) {
				uInd++;
			}

			int replength = uInd - i;
			endRank = strtRank + replength -1;
			
			// find the lower or upper bound of the end rank
			
			int strtInd = lowerBound(ranks, rankSize, strtRank);
			int endInd = lowerBound(ranks, rankSize, endRank);
			int s, sum = 0, cnt=0, strtWith = strtRank;
			for(s = strtInd+1; s<=endInd; s++) {
				cnt = s - strtWith;
				sum += (ranks.get(s) - ranks.get(strtWith)) * cnt;
				strtWith = ranks.get(s);
			}
			cnt = endRank - ranks.get(s) + 1;
			sum+= winningAmt.get(s) * cnt;
			
			strtRank = endRank + 1;
			
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
