package com.capgemini.chess.service;

import com.capgemini.chess.exception.EmailValidationException;
import com.capgemini.chess.exception.PasswordValidationException;
import com.capgemini.chess.exception.UserValidationException;

public interface UserUpdateValidatorService {

	public boolean validatePassword(String password) throws UserValidationException, PasswordValidationException;
	public boolean validateEmail(String email) throws UserValidationException, EmailValidationException;
}
