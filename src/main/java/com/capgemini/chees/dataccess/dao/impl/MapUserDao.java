package com.capgemini.chees.dataccess.dao.impl;

import java.util.*;
import org.springframework.stereotype.Repository;

import com.capgemini.chees.dataccess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

@Repository
public class MapUserDao implements UserDao {
	
	List<UserEntity> users = new ArrayList<UserEntity>();
	UserEntity user = new UserEntity();
	
	public List<UserProfileTO> findAll(){
		return UserProfileMapper.map2TOs(users);	
	}
	
	public UserProfileTO findById(Long id){
		return UserProfileMapper.map(user);	
	}
	
	public UserProfileTO save(UserEntity userEntity){
		return UserProfileMapper.map(user);	
	}
	
}
