package com.capgemini.chess.service.to;


import com.capgemini.chees.enums.MatchResult;

public class MatchTO {

	private long id;
	private long userFirstId;
	private long userSecondId;
	MatchResult matchStatus = MatchResult.UNDEFINED;
	
	public MatchTO(Long id, Long userFirstId, Long userSecondId, MatchResult matchStatus) {
		this.id = id;
		this.userFirstId = userFirstId;
		this.userSecondId = userSecondId;
		this.matchStatus = matchStatus;
	}
	
	public MatchTO(){
		
	}
	
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
