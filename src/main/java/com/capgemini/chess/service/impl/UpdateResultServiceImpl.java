package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chees.dataccess.dao.MatchDao;
import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.service.UpdateResultService;
import com.capgemini.chess.service.mapper.MatchMapper;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class UpdateResultServiceImpl implements UpdateResultService{

	@Autowired
	MatchDao matchDao;
	
	public MatchTO updateMatchStatus(MatchTO matchTo, MatchResult result){
		matchTo.setMatchStatus(result);
		return matchDao.save(MatchMapper.map(matchTo));		
	}
	
}
