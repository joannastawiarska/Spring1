package com.capgemini.chess.service;

import static org.junit.Assert.*;


import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.Before;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.impl.GetUserRankingServiceImpl;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.RankingRowTO;
import com.capgemini.chess.service.to.UserProfileTO;

import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetUserRankingServiceTest {
	
	@Mock
	UserValidatorService userValidator;
	
	GetUserRankingService rankingGetter = null;
	
	@Before
	public void setup() throws UserValidationException  {
		rankingGetter = new GetUserRankingServiceImpl(userValidator);
		when(userValidator.validate(anyLong())).thenReturn(true);
	}
	
	
	@Test
	public void findUserRankingTest() throws UserValidationException{
		
		//given
		List<RankingRowTO> users = new ArrayList<RankingRowTO>();
		users.add(new RankingRowTO(1L, "myszka", 443));
		users.add(new RankingRowTO(2L, "kotek", 333));
		users.add(new RankingRowTO(3L, "zuczek", 222));
		users.add(new RankingRowTO(4L, "zabka", 111));
		users.add(new RankingRowTO(5L, "paczus", 15));
		
		List<RankingRowTO> usersExpected = new ArrayList<RankingRowTO>();
		usersExpected.add(new RankingRowTO(1L, "myszka", 443));
		usersExpected.add(new RankingRowTO(2L, "kotek", 333));
		usersExpected.add(new RankingRowTO(3L, "zuczek", 222));
		usersExpected.add(new RankingRowTO(4L, "zabka", 111));
		usersExpected.add(new RankingRowTO(5L, "paczus", 15));
		
		//when
		List<RankingRowTO> usersActual = rankingGetter.findUserRanking(3L, users);
		
		//then
		assertEquals(5, usersActual.size());
	}
	
	@Test 
	public void findUserRankingOnToShortRankingTest() throws UserValidationException{
		
		//given
		List<RankingRowTO> users = new ArrayList<RankingRowTO>();
		users.add(new RankingRowTO(1L, "myszka", 443));
		users.add(new RankingRowTO(2L, "kotek", 333));
		users.add(new RankingRowTO(3L, "zuczek", 222));
		
		List<RankingRowTO> usersExpected = new ArrayList<RankingRowTO>();
		usersExpected.add(new RankingRowTO(2L, "kotek", 333));
		
		//when
		List<RankingRowTO> usersActual = rankingGetter.findUserRanking(2L, users);
		
		//then
		assertEquals(usersExpected.get(0).getId(),usersActual.get(0).getId());
		assertEquals(usersExpected.size(),usersActual.size());
	}
	
	@Test 
	public void findFirstUserRankingTest() throws UserValidationException{
		
		//given
		List<RankingRowTO> users = new ArrayList<RankingRowTO>();
		users.add(new RankingRowTO(1L, "myszka", 443));
		users.add(new RankingRowTO(2L, "kotek", 333));
		users.add(new RankingRowTO(3L, "zuczek", 222));
		
		List<RankingRowTO> usersExpected = new ArrayList<RankingRowTO>();
		usersExpected.add(new RankingRowTO(1L, "myszka", 443));
		
		//when
		List<RankingRowTO> usersActual = rankingGetter.findUserRanking(1L, users);
		
		//then
		assertEquals(usersExpected.get(0).getId(), usersActual.get(0).getId());
	}
	
	@Test 
	public void findFirstUserRankingTestFACADE4LLL() throws UserValidationException{
		
		//given
		List<RankingRowTO> users = new ArrayList<RankingRowTO>();
		users.add(new RankingRowTO(1L, "myszka", 443));
		users.add(new RankingRowTO(2L, "kotek", 333));
		users.add(new RankingRowTO(3L, "zuczek", 222));
		users.add(new RankingRowTO(4L, "zuczek", 111));
		
		List<RankingRowTO> usersExpected = new ArrayList<RankingRowTO>();
		usersExpected.add(new RankingRowTO(4L, "zuczek", 111));
		
		//when
		List<RankingRowTO> usersActual = rankingGetter.findUserRanking(4L, users);
		
		//then
		assertEquals(usersExpected.get(0).getId(), usersActual.get(0).getId());
		assertEquals(1, usersActual.size());
	}
	
	@Test 
	public void findFirstUserRankingTestFACADE2LLL() throws UserValidationException{
		
		//given
		List<RankingRowTO> users = new ArrayList<RankingRowTO>();
		users.add(new RankingRowTO(1L, "myszka", 622));
		users.add(new RankingRowTO(3L, "slonik", 433));
		users.add(new RankingRowTO(4L, "witek", 21));
		users.add(new RankingRowTO(2L, "zuczek", 20));
		
		List<RankingRowTO> usersExpected = new ArrayList<RankingRowTO>();
		usersExpected.add(new RankingRowTO(2L,"zuczek",20));
		
		//when
		List<RankingRowTO> usersActual = rankingGetter.findUserRanking(2L, users);
		
		//then
		assertEquals(usersExpected.get(0).getId(), usersActual.get(0).getId());
		assertEquals(1, usersActual.size());
	}
}
