package com.capgemini.chess.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.GetUserRankingService;
import com.capgemini.chess.service.UserValidatorService;
import com.capgemini.chess.service.to.RankingRowTO;

@Service
public class GetUserRankingServiceImpl implements GetUserRankingService{

	@Autowired
	UserValidatorService userValidator;
	
	
	public GetUserRankingServiceImpl(){
	}
	
	public GetUserRankingServiceImpl(UserValidatorService userValidator){
		this.userValidator = userValidator;
	}

	private List<RankingRowTO> users = new ArrayList<RankingRowTO>();
	
	public List<RankingRowTO> findUserRanking(Long id, List<RankingRowTO> userRanking) throws UserValidationException{
		userValidator.validate(id);
			for (int i = 0; i < userRanking.size() - 1; i++){
				if (userRanking.get(i).getId() == id && (i > 1 || i > userRanking.size() - 2) ){
					users.add(userRanking.get(i - 2));
					users.add(userRanking.get(i - 1));
					users.add(userRanking.get(i));
					users.add(userRanking.get(i + 1));
					users.add(userRanking.get(i + 2));
				}
				else if(userRanking.get(i).getId() == id) {
					users.add(userRanking.get(i));
				}
			}
		return users;
	}

	
}
