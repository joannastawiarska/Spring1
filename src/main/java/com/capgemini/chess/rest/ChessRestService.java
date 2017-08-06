package com.capgemini.chess.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.exception.MatchValidationException;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.RankingFacade;
import com.capgemini.chess.service.impl.RankingFacadeImpl;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.RankingRowTO;

@RestController
public class ChessRestService {

	@Autowired
	RankingFacadeImpl facade;

	@RequestMapping(value = "/get_ranking", method = RequestMethod.GET)
	public List<RankingRowTO> getRanking() throws UserValidationException {
		return facade.getRanking();
	}
	
	@RequestMapping(value = "/get_user_ranking/{id}" , method = RequestMethod.GET)
	public List<RankingRowTO> getUserRanking(@PathVariable("id") Long id) throws UserValidationException{
		return facade.getUserRanking(id);
	}
	
	@RequestMapping(value = "/register_match_result" , method = RequestMethod.POST)
	public MatchTO registerMatchResult(@RequestParam MatchResult matchResult, @RequestParam Long id) throws MatchValidationException, UserValidationException{
		return facade.registerMatchResult(matchResult, id);
	}
	
}
