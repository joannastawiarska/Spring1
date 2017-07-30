package com.capgemini.chess.service;

import com.capgemini.chess.exception.MatchValidationException;

public interface MatchValidatorService {

	public boolean validate(Long id) throws MatchValidationException;
	
}
