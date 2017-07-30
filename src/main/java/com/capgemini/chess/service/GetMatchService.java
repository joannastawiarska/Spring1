package com.capgemini.chess.service;

import com.capgemini.chess.service.to.MatchTO;

public interface GetMatchService {

	public MatchTO getMatchById(Long id);
	
}
