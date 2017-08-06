package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.exception.EmailValidationException;
import com.capgemini.chess.exception.MatchValidationException;
import com.capgemini.chess.exception.PasswordValidationException;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.GetUserRankingService;
import com.capgemini.chess.service.MatchResultRegisterService;
import com.capgemini.chess.service.RankingFacade;
import com.capgemini.chess.service.RankingPrepareService;
import com.capgemini.chess.service.UpdateUserService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.RankingRowTO;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class RankingFacadeImpl implements RankingFacade {

	@Autowired
	private RankingPrepareService rankingPrepareService;
		
	@Autowired
	private GetUserRankingService userRankingService;
		
	@Autowired
	private MatchResultRegisterService matchResultRegisterService;
	
	@Autowired 
	UpdateUserService updateUserService;
	
	public List<RankingRowTO> getRanking(){
		return rankingPrepareService.prepareRanking();
	}
		
	public List<RankingRowTO> getUserRanking(Long id) throws UserValidationException{
		return userRankingService.findUserRanking(id, rankingPrepareService.prepareRanking());
	}
	
	public MatchTO registerMatchResult(MatchResult matchResult, Long id) throws MatchValidationException, UserValidationException{
		return matchResultRegisterService.registerMatchResult(matchResult, id);
	}
	
	public void updateUser(UserProfileTO userProfile) throws UserValidationException, PasswordValidationException, EmailValidationException {
		updateUserService.updateUser(userProfile);
	}
	
	
		
		
}

