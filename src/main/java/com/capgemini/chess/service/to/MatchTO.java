package com.capgemini.chess.service.to;


import com.capgemini.chees.enums.MatchResult;

public class MatchTO {

	private long id;
	private long userFirstId;
	private long userSecondId;
	MatchResult matchStatus = MatchResult.UNDEFINED;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserFirstId() {
		return userFirstId;
	}

	public void setUserFirstId(long userFirstId) {
		this.userFirstId = userFirstId;
	}

	public long getUserSecondId() {
		return userSecondId;
	}

	public void setUserSecondId(long userSecondId) {
		this.userSecondId = userSecondId;
	}

	public MatchResult getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(MatchResult matchStatus) {
		this.matchStatus = matchStatus;
	}
	
	
}
