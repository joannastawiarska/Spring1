package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.to.RankingRowTO;

public interface GetUserRankingService {

	public List<RankingRowTO> findUserRanking(Long id, List<RankingRowTO> userRanking)  throws UserValidationException;
	
}
