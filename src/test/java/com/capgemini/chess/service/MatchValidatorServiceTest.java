package com.capgemini.chess.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.capgemini.chees.dataccess.dao.MatchDao;
import com.capgemini.chess.exception.MatchValidationException;
import com.capgemini.chess.service.impl.MatchValidatorServiceImpl;
import com.capgemini.chess.service.to.MatchTO;

public class MatchValidatorServiceTest {

	@Mock
	MatchDao matchDao;
	
	@Mock
	MatchTO match;
	
	MatchValidatorService matchValidator = null;
	
	@Before
	public void setup()  {
		matchValidator = new MatchValidatorServiceImpl(matchDao);
	}
	
	@Test
	public void matchValidateTestWrongId(){
		
		//given
		Long id = -1L;
		
		//when
		boolean exceptionThrown = false;
		try {
			matchValidator.validate(id);
		} catch (MatchValidationException e) {
			exceptionThrown = true;
		}
		
		//then
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void matchValidateTestNullId(){
		
		//given
		Long id = -1L;
		
		//when
		boolean exceptionThrown = false;
		try {
			matchValidator.validate(id);
		} catch (MatchValidationException e) {
			exceptionThrown = true;
		}
		
		//then
		assertTrue(exceptionThrown);
	}

}
