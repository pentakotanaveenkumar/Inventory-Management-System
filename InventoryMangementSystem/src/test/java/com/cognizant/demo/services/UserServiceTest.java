package com.cognizant.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.demo.entity.User;
import com.cognizant.demo.exception.UserAlreadyExistsException;
import com.cognizant.demo.repository.UserRepository;
import com.cognizant.demo.service.AppUserDetailsService;
import com.cognizant.demo.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	AppUserDetailsService appUserDetailsService;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Test
	public void testSignUp() throws UserAlreadyExistsException {
		User user=new User(1, "naveen", "123", "Naveen", "Kumar", 9642845519l, "pentakota@gmail.com");
		userServiceImpl.signUp(user);
		verify(appUserDetailsService,times(1)).signUp(user);
	}
	
	@Test
	public void testGetUserDetails() {
		User user=new User(1, "naveen", "123", "Naveen", "Kumar", 9642845519l, "pentakota@gmail.com");
		when(userRepository.findbyUsername(user.getUsername())).thenReturn(user);
		assertEquals(user.getFirstName(), userServiceImpl.getuserDetails(user.getUsername()).getFirstName());
	}

}
