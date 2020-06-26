package com.cognizant.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.demo.entity.User;
import com.cognizant.demo.exception.UserAlreadyExistsException;
import com.cognizant.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags= {"User Entity"})
@RestController
@RequestMapping("/inventory")
public class UserController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "User Login", notes = "")
	@PostMapping("/users")
	public void signUp(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		LOGGER.debug("Inside UserController.signUp() method");
		userService.signUp(user);
	}
	
	@ApiOperation(value = "Get Username", notes = "")
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		LOGGER.debug("Inside UserController.getUser() method");
		return userService.getuserDetails(username);
	}
}
