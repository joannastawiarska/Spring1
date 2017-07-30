package com.capgemini.chess.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserServiceTest.class,SortServiceTest.class,CalculateNewStatsServiceTest.class,GetUserRankingServiceTest.class, MatchValidatorServiceTest.class, UserUpdateValidatorServiceTest.class})
public class ServiceTestSuite {

}
