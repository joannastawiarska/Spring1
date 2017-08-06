package com.capgemini.chees.dataccess.dao.impl;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capgemini.chees.dataccess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class MapUserDao implements UserDao {
	
	private final List<UserEntity> users;
	private final UserEntity user;
	
	public MapUserDao(){
		this.users = setupDatabase();
		this.user = users.get(0);
	}
	
	
	public List<UserProfileTO> findAll(){
		return UserProfileMapper.map2TOs(users);	
	}
	
	public UserProfileTO findById(Long id){
		return UserProfileMapper.map(user);	
	}
	
	public UserProfileTO save(UserEntity userEntity){
		return UserProfileMapper.map(user);	
	}
	
	public List<UserEntity> setupDatabase(){
		List<UserEntity>  users = new ArrayList <UserEntity>();
		users.add(UserProfileMapper.map(new UserProfileTO(1L,"myszka",622)));
		users.add(UserProfileMapper.map(new UserProfileTO(2L,"zuczek",20)));
		users.add(UserProfileMapper.map(new UserProfileTO(3L,"slonik",433)));
		users.add(UserProfileMapper.map(new UserProfileTO(4L,"witek",21)));
		return users;
	}
	
}
