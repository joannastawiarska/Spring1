package com.capgemini.chess.service;

import com.capgemini.chess.exception.UserValidationException;

public interface UserValidatorService {

	public boolean validate(Long id) throws UserValidationException;
}
