package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chees.dataccess.dao.UserDao;
import com.capgemini.chess.exception.EmailValidationException;
import com.capgemini.chess.exception.PasswordValidationException;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.UpdateUserService;
import com.capgemini.chess.service.UserUpdateValidatorService;
import com.capgemini.chess.service.UserValidatorService;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class UpdateUserServiceImpl implements UpdateUserService{
	
	@Autowired
	private UserValidatorService userValidator;
	
	@Autowired
	private UserUpdateValidatorService userUpdateValidator;
	
	@Autowired
	private UserDao userDao;
	
	public void updateUser(UserProfileTO userProfile) throws UserValidationException, PasswordValidationException, EmailValidationException {
		userValidator.validate(userProfile.getId());
		userUpdateValidator.validatePassword(userProfile.getPassword());
		userUpdateValidator.validateEmail(userProfile.getEmail());
		userDao.save(UserProfileMapper.map(userProfile));
	}
	
}
