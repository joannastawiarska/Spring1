package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.UserProfileTO;

public interface ReadUserService {

	public List<UserProfileTO> findAll();
	public UserProfileTO findById(Long id);
	
}
