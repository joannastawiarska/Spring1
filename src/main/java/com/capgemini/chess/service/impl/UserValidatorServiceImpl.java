package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chees.dataccess.dao.UserDao;
import com.capgemini.chees.dataccess.dao.impl.MapUserDao;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.UserValidatorService;


@Service
public class UserValidatorServiceImpl implements UserValidatorService {
	
	@Autowired
	private UserDao userDao;

	public boolean validate(Long id) throws UserValidationException{

		if (null == id || id < 0) {
			throw new UserValidationException("Wrong user ID.");
		}
		else if (null == userDao.findById(id)){
			throw new UserValidationException("User with this ID doesn't exist.");
		}
		else {
			return true;
		}
	}
}
