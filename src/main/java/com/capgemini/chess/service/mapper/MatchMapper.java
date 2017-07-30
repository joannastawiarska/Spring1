package com.capgemini.chess.service.mapper;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.to.MatchTO;

public class MatchMapper {

	public static MatchTO map(MatchEntity matchEntity) {
		if (matchEntity != null) {
			MatchTO matchTO = new MatchTO();
			matchTO.setId(matchEntity.getId());
			matchTO.setUserFirstId(matchEntity.getUserFirstId());
			matchTO.setUserSecondId(matchEntity.getUserSecondId());
			matchTO.setMatchStatus(matchEntity.getMatchStatus());
			return matchTO;
		}
		return null;
	}

	public static MatchEntity map(MatchTO matchTO) {
		if (matchTO != null) {
			MatchEntity matchEntity = new MatchEntity();
			matchEntity.setId(matchTO.getId());
			matchEntity.setUserFirstId(matchTO.getUserFirstId());
			matchEntity.setUserSecondId(matchTO.getUserSecondId());
			matchEntity.setMatchStatus(matchTO.getMatchStatus());
			return matchEntity;
		}
		return null;
	}
	
}
