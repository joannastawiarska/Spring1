package com.capgemini.chees.dataccess.dao;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.service.to.MatchTO;

public interface MatchDao {

	public MatchTO findById(Long id);
	public MatchTO save(MatchEntity matchEntity); //jeżeli match entity ma id które już jest w bazie - update, jeżeli nie ma takiego id - zapisujemy nowy match
	
}
