package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.service.RankingPrepareService;
import com.capgemini.chess.service.ReadUserService;
import com.capgemini.chess.service.to.RankingRowTO;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class RankingPrepareServiceImpl implements RankingPrepareService {

	@Autowired
	private ReadUserService readUserService;

	@Autowired
	private SortUserServiceImpl sortUserService;

	private List<RankingRowTO> rankingUsers;

	public List<RankingRowTO> prepareRanking() {

		List<UserProfileTO> rankingProfileTO = readUserService.findAll();

		for (int i = 0; i < rankingProfileTO.size() - 1; i++) {
			rankingUsers.add(new RankingRowTO(rankingProfileTO.get(i).getId(), rankingProfileTO.get(i).getLogin(),
					rankingProfileTO.get(i).getPoints()));
		}
		List<RankingRowTO> sortedRankingUsers = sortUserService.sortByPoints(rankingUsers);
		return sortedRankingUsers;
		
	}
}
