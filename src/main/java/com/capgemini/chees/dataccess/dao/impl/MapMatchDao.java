package com.capgemini.chees.dataccess.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.chees.dataccess.dao.MatchDao;
import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.mapper.MatchMapper;
import com.capgemini.chess.service.to.MatchTO;

@Repository
public class MapMatchDao implements MatchDao {

	private final MatchEntity matchEntity;
	
	public MapMatchDao(){
		this.matchEntity = setupDatabase();
	}
	
	public MatchTO findById(Long id){
		return MatchMapper.map(matchEntity);
	}
	
   public MatchTO save(MatchEntity matchEntity){
	   return MatchMapper.map(matchEntity);
   }
	
   public MatchEntity setupDatabase(){
	   MatchEntity matchEntity = MatchMapper.map((new MatchTO(1L, 1L, 2L, MatchResult.UNDEFINED)));
	   return matchEntity;
   	}
}