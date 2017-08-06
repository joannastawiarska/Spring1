package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chees.dataccess.dao.UserDao;
import com.capgemini.chess.service.UpdateStatsService;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class UpdateStatsServiceImpl implements UpdateStatsService {
	
	@Autowired
	private UserDao userDao;
	
	public void updateStats(UserProfileTO userProfile){
		userDao.save(UserProfileMapper.map(userProfile));
	}
}
