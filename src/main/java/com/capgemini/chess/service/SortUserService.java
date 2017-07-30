package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.RankingRowTO;

public interface SortUserService {
	
	public List<RankingRowTO> sortByPoints(List<RankingRowTO> toSortUser);
}
