package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.exception.MatchValidationException;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.CalculateNewStatsService;
import com.capgemini.chess.service.GetMatchService;
import com.capgemini.chess.service.MatchResultRegisterService;
import com.capgemini.chess.service.MatchValidatorService;
import com.capgemini.chess.service.UpdateResultService;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class MatchResultRegisterServiceImpl implements MatchResultRegisterService {

	@Autowired
	private MatchValidatorService matchValidator;
	
	@Autowired
	private GetMatchService matchGetter;
	
	@Autowired
	private UpdateResultService resultUpdater;
	
	@Autowired 
	private CalculateNewStatsService stateCalculator;
	
	private MatchTO matchTo;
	
	public boolean registerMatchResult(MatchResult matchResult, Long id) throws MatchValidationException, UserValidationException{
		
		if (matchValidator.validate(id)) {
			matchTo = matchGetter.getMatchById(id);
			matchTo = resultUpdater.updateMatchStatus(matchTo, matchResult);
			stateCalculator.calculateStats(matchTo);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
}
