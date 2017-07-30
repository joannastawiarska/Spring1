package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.capgemini.chees.enums.MatchResult;
@Entity
public class MatchEntity {

	@Id
	@GeneratedValue
	private long id;
	private long userFirstId;
	private long userSecondId;
	MatchResult matchStatus = MatchResult.UNDEFINED;
	
	public long getId() {
		return id;
	}

	public long getUserFirstId() {
		return userFirstId;
	}

	public void setId(long id) {
		this.id = id;
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
