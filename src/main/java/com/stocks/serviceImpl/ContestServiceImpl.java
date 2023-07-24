package com.stocks.serviceImpl;

import java.util.ArrayList;
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

	int lowerBound(List<Integer>L, int x, int si, int ei) {
		
		int start = si , end = ei;
		
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
	
	int upperBound(List<Object[]>L, Double x, int si, int ei) {
		
		int start = si , end = ei;
		
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
	public List<Object[]> setWinners(ContestDetails contest) {
		List<Object[]> resList = new ArrayList<>();
		
		Map<Integer, Integer> winningAmt = null;
		List<Integer> ranks = new ArrayList<>(winningAmt.keySet());
		int rankSize = ranks.size();
		
		List<Object[]> lBoard = pointsTableRepository.getLeaderboard(contest.getConCode());
		
		int strtLBoardIndx = 0, endLBoardIndx = 0, strtRankIndx = 0;
		int i,j,ls=lBoard.size();
		for(i = 0; i < ls; i++) {
			Object[] obj = lBoard.get(i);
			//Long user_id =  (Long)obj[0];
			double points = (double)obj[1];
			
			// get the length of repeated values
			int uInd = upperBound(lBoard, points, strtLBoardIndx, ls-1);
			Object[] indObj = lBoard.get(uInd);
			double indPoints = (double) indObj[1];
			if(indPoints == points) {
				uInd++;
			}

			int replength = uInd - i;
			endLBoardIndx = uInd - 1;
			
			// find the lower bound of the start rank and end rank
			
			int strtInd = lowerBound(ranks, strtLBoardIndx+1, strtRankIndx, rankSize-1);
			int endInd = lowerBound(ranks, endLBoardIndx+1, strtRankIndx, rankSize-1);
			strtRankIndx = endInd;
			
			int r = strtInd+1 , sum = 0, cnt=0, strtWith = strtLBoardIndx+1;
			for(r = strtInd+1; r <= endInd; r++) {
				cnt = ranks.get(r)  - strtWith;
				sum += winningAmt.get(ranks.get(r-1)) * cnt;
				strtWith = ranks.get(r);
			}
			r--;
			if(strtInd == endInd) {
				cnt = replength;
			}
			else {
				cnt = endLBoardIndx + 1 - ranks.get(r) + 1;
			}
			sum+= winningAmt.get(ranks.get(r)) * cnt;
			
			double sharedAmt = (double)sum/replength;
			
			for(int res=strtLBoardIndx; res<=endLBoardIndx; res++) {
				Object[] objArr = new Object[3];
				objArr[0]=lBoard.get(res)[0]; //userId
				objArr[1]=lBoard.get(res)[1]; //points
				objArr[2]=sharedAmt; //winning amount
				
				resList.add(objArr);
			}
			
			strtLBoardIndx = endLBoardIndx + 1;
			i = endLBoardIndx;
			
		}
		
		return resList;
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
