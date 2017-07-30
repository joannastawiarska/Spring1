package com.capgemini.chees.dataccess.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.chees.dataccess.dao.MatchDao;
import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.mapper.MatchMapper;
import com.capgemini.chess.service.to.MatchTO;

@Repository
public class MapMatchDao implements MatchDao {

	MatchEntity matchEntity = new MatchEntity();
	
	public MatchTO findById(Long id){
		return MatchMapper.map(matchEntity);
	}
	
   public MatchTO save(MatchEntity matchEntity){
	   return MatchMapper.map(matchEntity);
   }
	
}
