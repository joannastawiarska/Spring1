package com.capgemini.chess.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.exception.EmailValidationException;
import com.capgemini.chess.exception.PasswordValidationException;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.UserUpdateValidatorService;

@Service
public class UserUpdateValidatorServiceImpl implements UserUpdateValidatorService {
	
	public boolean validatePassword(String password) throws UserValidationException, PasswordValidationException {
		if (password.length() < 8 || password == null) {
			throw new PasswordValidationException("Password is  wrong. Try again.");
		}
		else {
			return true;
		}
	}
	
	public boolean validateEmail(String email) throws UserValidationException, EmailValidationException {
		if ( null == email || !(email.matches("[a-zA-Z0-9-_.]+@[a-z0-9-.]+.[a-z0-9]{1,4}"))) {
         throw new EmailValidationException("Email is  wrong. Try again.");			
		} else {
			return true;
		}
	}
	
}
