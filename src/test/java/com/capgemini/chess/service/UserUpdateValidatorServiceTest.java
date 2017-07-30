package com.capgemini.chess.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.exception.EmailValidationException;
import com.capgemini.chess.exception.PasswordValidationException;
import com.capgemini.chess.exception.UserValidationException;
import com.capgemini.chess.service.impl.UserUpdateValidatorServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserUpdateValidatorServiceTest {

	@Autowired
	UserUpdateValidatorService userUpdateValidator;
	
	@Configuration
	static class SortServiceTestContextConfiguration {
		
		@Bean
		public UserUpdateValidatorService userUpdateValidatorService() {
			return new UserUpdateValidatorServiceImpl();
		}
	}
	
	@Test
	public void validatePasswordToShortTest() throws UserValidationException{
		
		//given
		String password = "xxx";
		
		//when
		boolean exceptionThrown = false;
		try {
			userUpdateValidator.validatePassword(password);
		} catch (PasswordValidationException e) {
			exceptionThrown = true;
		}
		
		//then
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void validatePasswordTest() throws UserValidationException, PasswordValidationException{
		
		//given
		String password = "aabbccdd";
		
		//when
		boolean result = userUpdateValidator.validatePassword(password);
		
		//then
		assertTrue(result);
	}
	
	@Test
	public void validateEmailTest() throws UserValidationException, EmailValidationException{
		
		//given
		String email = "jan.kowalski@o2.pl";
		
		//when
		boolean result = userUpdateValidator.validateEmail(email);
		
		//then
		assertTrue(result);
	}
	
	@Test
	public void validateEmailNullTest() throws UserValidationException, EmailValidationException{
		
		//given
		String email = null;
		
		//when
		boolean exceptionThrown = false;
		try {
			userUpdateValidator.validateEmail(email);
		} catch (EmailValidationException e) {
			exceptionThrown = true;
		}
		
		//then
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void validateEmailWrongSyntaxTest() throws UserValidationException, EmailValidationException{
		
		//given
		String email = "Jan.kowalski";
		
		//when
		boolean exceptionThrown = false;
		try {
			userUpdateValidator.validateEmail(email);
		} catch (EmailValidationException e) {
			exceptionThrown = true;
		}
		
		//then
		assertTrue(exceptionThrown);
	}

}
