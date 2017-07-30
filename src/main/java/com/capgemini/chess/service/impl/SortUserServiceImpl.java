package com.capgemini.chess.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.SortUserService;
import com.capgemini.chess.service.to.RankingRowTO;

@Service
public class SortUserServiceImpl implements SortUserService {

	public List<RankingRowTO> sortByPoints(List<RankingRowTO> toSortUser){
		
		Collections.sort(toSortUser, (u1, u2) -> u1.getPoints().compareTo(u2.getPoints()));
		Collections.reverse(toSortUser); 
		return toSortUser;
		
	}
	
}