package com.capgemini.chess.service;

import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.exception.MatchValidationException;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.MatchTO;

public interface MatchResultRegisterService {

	public MatchTO registerMatchResult(MatchResult matchResult, Long id) throws MatchValidationException, UserValidationException;	
	
}
