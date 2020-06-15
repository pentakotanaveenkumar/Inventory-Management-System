package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserAlreadyExistsException;

public interface UserService {
	public void signUp(User user) throws UserAlreadyExistsException;
	
	public User getuserDetails(String username);
}
