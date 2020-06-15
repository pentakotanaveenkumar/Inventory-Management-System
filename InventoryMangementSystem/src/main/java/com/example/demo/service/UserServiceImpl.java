
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	/* UserDao userDao; */
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	UserRepository userRepository;
	@Override
	public void signUp(User user) throws UserAlreadyExistsException {
		appUserDetailsService.signUp(user);
	}
	@Override
	public User getuserDetails(String username) {
		return userRepository.findbyUsername(username);
	}

}
