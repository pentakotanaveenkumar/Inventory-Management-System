package com.cognizant.demo.service;

import com.cognizant.demo.entity.User;
import com.cognizant.demo.exception.UserAlreadyExistsException;

public interface UserService {
	public void signUp(User user) throws UserAlreadyExistsException;
	
	public User getuserDetails(String username);
}
