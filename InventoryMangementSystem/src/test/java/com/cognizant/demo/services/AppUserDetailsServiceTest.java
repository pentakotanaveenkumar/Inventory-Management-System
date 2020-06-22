package com.cognizant.demo.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cognizant.demo.entity.User;
import com.cognizant.demo.exception.UserAlreadyExistsException;
import com.cognizant.demo.repository.RoleRepository;
import com.cognizant.demo.repository.UserRepository;
import com.cognizant.demo.service.AppUserDetailsService;

@RunWith(MockitoJUnitRunner.class)
public class AppUserDetailsServiceTest {
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	RoleRepository roleRepository;
	
	@InjectMocks
	AppUserDetailsService appUserDetailsService;
	
	@Test(expected= UsernameNotFoundException.class)
	public void testLoadUserByUsername() {
		when(userRepository.findbyUsername("naveen")).thenThrow(new UsernameNotFoundException("Username not found"));
		appUserDetailsService.loadUserByUsername("naveen");
	}
	
	@Test
	public void testSignUp() throws UserAlreadyExistsException {
		User user=new User(1, "naveen", "123", "Naveen", "Kumar", 9642845519l, "pentakota@gmail.com");
		when(userRepository.findbyUsername(user.getUsername())).thenReturn(null);
		appUserDetailsService.signUp(user);
		verify(userRepository).save(user);
	}

}
