package com.capgemini.chess.service.to;

public class RankingRowTO {
	
		private long id;
		private String login;
		private Integer points;
		
		public RankingRowTO(long id, String login, Integer points) {
			this.id = id;
			this.login = login;
			this.points = points;
		}
		
		@Override
		public String toString() {
			return "RankingRowTO [id=" + id + ", login=" + login + ", points=" + points + "]";
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public Integer getPoints() {
			return points;
		}
		public void setPoints(Integer points) {
			this.points = points;
		}
		
	}

