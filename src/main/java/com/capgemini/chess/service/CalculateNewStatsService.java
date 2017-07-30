package com.capgemini.chess.service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.UserProfileTO;

public interface CalculateNewStatsService {

	public void calculateStats(MatchTO matchTo) throws UserValidationException;
	public UserProfileTO calculatePoints(UserProfileTO user, String result);
	public UserProfileTO calculateLevel(UserProfileTO user);
	
}
