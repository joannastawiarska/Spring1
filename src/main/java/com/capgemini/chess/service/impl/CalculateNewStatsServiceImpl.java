package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chees.enums.Level;
import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.CalculateNewStatsService;
import com.capgemini.chess.service.ReadUserService;
import com.capgemini.chess.service.UpdateStatsService;
import com.capgemini.chess.service.UserValidatorService;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class CalculateNewStatsServiceImpl implements CalculateNewStatsService {

	@Autowired
	private UserValidatorService userValidator;
	
	@Autowired
	private UpdateStatsService stateUpdater;
	
	@Autowired
	private ReadUserService userReader; 
	
	private MatchResult matchResult;
	private UserProfileTO userFirst;
    private UserProfileTO userSecond;
    
	public CalculateNewStatsServiceImpl(){
	}
	
	public CalculateNewStatsServiceImpl(UserValidatorService userValidator, UpdateStatsService stateUpdater, ReadUserService userReader){
		this.userValidator = userValidator;
		this.stateUpdater = stateUpdater;
		this.userReader = userReader;
	}
	
	public void calculateStats(MatchTO matchTo) throws UserValidationException  {
		matchResult = matchTo.getMatchStatus();
		
		userValidator.validate(matchTo.getUserFirstId());
		userValidator.validate(matchTo.getUserSecondId());
		
		userFirst = userReader.findById(matchTo.getUserFirstId());
		userSecond = userReader.findById(matchTo.getUserSecondId());
	
		if (matchResult == MatchResult.LOST_USER_FIRST) {
			userFirst = calculatePoints(userFirst, "LOST");
			userSecond = calculatePoints(userSecond, "WON");
		}
		else if(matchResult == MatchResult.WON_USER_FIRST){
			userFirst = calculatePoints(userFirst, "WON");
			userSecond = calculatePoints(userSecond, "LOST");
		}
		
		userFirst = calculateLevel(userFirst);
		userSecond = calculateLevel(userSecond);
		
        stateUpdater.updateStats(userFirst);
        stateUpdater.updateStats(userSecond);
		
	}
	
	public UserProfileTO calculatePoints(UserProfileTO user, String result) {
		if (result.equals("WON")) {
			user.setPoints(user.getPoints() + 10);
		}
		else {
			user.setPoints(user.getPoints() - 10);
			} 
		return user;
		}
	
	public UserProfileTO calculateLevel(UserProfileTO user){
		Integer points = user.getPoints();
		if (points < 0) {
			points = 0;
		}
		if (points >= 0 && points < 50) {
			user.setLevel(Level.BABY);
		}
		else if (points >= 50 && points < 100) {
			user.setLevel(Level.BEGINNER);
		}
		else if (points >= 100 && points < 150) {
			user.setLevel(Level.PLAYER);
		}
		else if (points >= 150 && points < 200) {
			user.setLevel(Level.PROFESSIONAL);
		}
		else {
			user.setLevel(Level.MASTER);
		}
		return user;
	}
}
