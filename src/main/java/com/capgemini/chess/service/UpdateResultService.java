package com.capgemini.chess.service;


import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.service.to.MatchTO;

public interface UpdateResultService {

	public MatchTO updateMatchStatus(MatchTO matchTo, MatchResult result);
	
}
