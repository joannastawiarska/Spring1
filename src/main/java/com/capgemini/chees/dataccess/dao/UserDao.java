package com.capgemini.chees.dataccess.dao;


import java.util.List;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserProfileTO;

public interface UserDao {
	
public List<UserProfileTO> findAll();

public UserProfileTO findById(Long id);

public UserProfileTO save(UserEntity userEntity);

}
