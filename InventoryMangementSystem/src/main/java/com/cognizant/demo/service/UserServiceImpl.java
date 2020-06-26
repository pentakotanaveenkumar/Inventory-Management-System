
package com.cognizant.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.demo.entity.User;
import com.cognizant.demo.exception.UserAlreadyExistsException;
import com.cognizant.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	/* UserDao userDao; */
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	UserRepository userRepository;
	@Override
	public void signUp(User user) throws UserAlreadyExistsException {
		LOGGER.debug("Inside UserServiceImpl.signUp() method");
		appUserDetailsService.signUp(user);
	}
	@Override
	public User getuserDetails(String username) {
		LOGGER.debug("Inside UserServiceImpl.getUserDetails() method");
		return userRepository.findbyUsername(username);
	}

}
