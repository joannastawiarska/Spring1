package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chees.dataccess.dao.MatchDao;
import com.capgemini.chess.exception.MatchValidationException;
import com.capgemini.chess.service.MatchValidatorService;
import com.capgemini.chess.service.to.MatchTO;

@Service
public class MatchValidatorServiceImpl implements MatchValidatorService{
	
	@Autowired
	private MatchDao matchDao;

	private MatchTO matchTo;
	
	public MatchValidatorServiceImpl(){
	}
	
	public MatchValidatorServiceImpl(MatchDao matchDao){
		this.matchDao = matchDao;
	}
	
	public boolean validate(Long id) throws MatchValidationException{
		if (null == id || id < 0){
			throw new MatchValidationException("Wrong match's ID.");
		}
		else if (null == matchDao.findById(id)) {
			throw new MatchValidationException("Match doesn't exist.");
		}
		else {
			return true;
		}
	}

	public MatchTO getMatchTo() {
		return matchTo;
	}

	public void setMatchTo(MatchTO matchTo) {
		this.matchTo = matchTo;
	}
	
	
	
}
