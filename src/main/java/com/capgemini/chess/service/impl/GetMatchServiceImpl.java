package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chees.dataccess.dao.MatchDao;
import com.capgemini.chess.service.GetMatchService;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class GetMatchServiceImpl implements GetMatchService{
	
	@Autowired
	private MatchDao matchDao;
	
	public MatchTO getMatchById(Long id){
		return matchDao.findById(id);
	}

}
