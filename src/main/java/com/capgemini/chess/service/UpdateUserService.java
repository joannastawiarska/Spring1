package com.capgemini.chess.service;

import com.capgemini.chess.exception.EmailValidationException;
import com.capgemini.chess.exception.PasswordValidationException;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.UserProfileTO;

public interface UpdateUserService {
	public void updateUser(UserProfileTO userProfile) throws UserValidationException, PasswordValidationException, EmailValidationException;
}
