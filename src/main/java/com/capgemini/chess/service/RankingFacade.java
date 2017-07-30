package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.exception.EmailValidationException;
import com.capgemini.chess.exception.MatchValidationException;
import com.capgemini.chess.exception.PasswordValidationException;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.RankingRowTO;
import com.capgemini.chess.service.to.UserProfileTO;

public interface RankingFacade {

	public List<RankingRowTO> getRanking()  throws UserValidationException;
	public List<RankingRowTO> getUserRanking(Long id) throws UserValidationException;
	public void registerMatchResult(MatchResult matchResult, Long id) throws MatchValidationException, UserValidationException;
	public void updateUser(UserProfileTO userProfile) throws UserValidationException, PasswordValidationException, EmailValidationException; 
	
}
