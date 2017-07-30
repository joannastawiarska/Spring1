package com.capgemini.chess.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.capgemini.chees.enums.Level;
import com.capgemini.chess.service.impl.CalculateNewStatsServiceImpl;
import com.capgemini.chess.service.to.UserProfileTO;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration
public class CalculateNewStatsServiceTest {

	CalculateNewStatsService calculateNewStatsService = null;
	
	@Mock
	UserValidatorService userValidator;
	
	@Mock
	UpdateStatsService stateUpdater;
	
	@Mock
	ReadUserService userReader;
	
	@Before
	public void setup()  {
		calculateNewStatsService = new CalculateNewStatsServiceImpl(userValidator, stateUpdater, userReader);
	}
	
	@Test
	public void calculatePointsTest(){
		
		//given
		UserProfileTO user = new UserProfileTO(1L, "myszka", 10);
		//when
		calculateNewStatsService.calculatePoints(user, "WON");
		//then
		assertEquals(new Integer(20), user.getPoints());
	}
	
	@Test
	public void calculateLevelTest(){
		
		//given
		UserProfileTO user = new UserProfileTO(1L, "myszka", 99);
		//when
		calculateNewStatsService.calculateLevel(user);
		//then
		assertEquals(Level.BEGINNER, user.getLevel());
	}
	
	@Test
	public void calculateLevelPointUnderZeroTest(){
		
		//given
		UserProfileTO user = new UserProfileTO(1L, "myszka", -333);
		//when
		user = calculateNewStatsService.calculateLevel(user);
		//then
		assertEquals(Level.BABY, user.getLevel());
	}

}
