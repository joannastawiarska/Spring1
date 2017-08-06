package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.service.impl.SortUserServiceImpl;
import com.capgemini.chess.service.to.RankingRowTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SortServiceTest {
	
	@Autowired
	SortUserService sortUserService;
	
	@Configuration
	static class SortServiceTestContextConfiguration {
		
		@Bean
		public SortUserService sortUserService() {
			return new SortUserServiceImpl();
		}	
	}
	
	@Test
	public void sortByPointsTest(){
		
		//given
		List<RankingRowTO> users = new ArrayList<RankingRowTO>();
		users.add(new RankingRowTO(1L, "myszka", 453));
		users.add(new RankingRowTO(2L, "kotek", 55));
		users.add(new RankingRowTO(3L, "zuczek", 2));
		
		//when
		List<RankingRowTO> usersActual = sortUserService.sortByPoints(users);
		
		//then
		assertEquals(new Integer(453), usersActual.get(0).getPoints());
	}
	
	
	@Test
	public void sortByPointsTestFACADE(){
		
		//given
		List<RankingRowTO> users = new ArrayList<RankingRowTO>();
		users.add(new RankingRowTO(1L, "myszka", 622));
		users.add(new RankingRowTO(2L, "zuczek", 20));
		users.add(new RankingRowTO(3L, "slonik", 433));
		users.add(new RankingRowTO(4L, "witek", 21));
		
		//when
		List<RankingRowTO> usersActual = sortUserService.sortByPoints(users);
		
		//then
		assertEquals(new Integer(622), usersActual.get(0).getPoints());
		assertEquals(new Integer(20), usersActual.get(3).getPoints());
	}
	//given
			
}
