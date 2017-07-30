package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chees.dataccess.dao.UserDao;
import com.capgemini.chess.service.ReadUserService;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class ReadUserServiceImpl implements ReadUserService {

	@Autowired
	private UserDao userDao;
	
	public List<UserProfileTO> findAll(){
		List<UserProfileTO> users = userDao.findAll();
		return users;
	}
	
	public UserProfileTO findById(Long id){
		UserProfileTO user = userDao.findById(id);
		return user;
	}
	
}
