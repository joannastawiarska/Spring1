package com.capgemini.chess.service;

import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.exception.MatchValidationException;
import com.capgemini.chess.exception.UserValidationException;

public interface MatchResultRegisterService {

	public boolean registerMatchResult(MatchResult matchResult, Long id) throws MatchValidationException, UserValidationException;	
	
}
