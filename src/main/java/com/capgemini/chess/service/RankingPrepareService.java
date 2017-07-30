package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.RankingRowTO;
import com.capgemini.chess.service.to.UserProfileTO;

public interface RankingPrepareService {

	public List<RankingRowTO> prepareRanking();

}
