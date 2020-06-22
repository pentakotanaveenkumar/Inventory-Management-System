package com.cognizant.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.demo.entity.Role;
import com.cognizant.demo.entity.User;
import com.cognizant.demo.exception.UserAlreadyExistsException;
import com.cognizant.demo.repository.RoleRepository;
import com.cognizant.demo.repository.UserRepository;
import com.cognizant.demo.security.AppUser;

@Service
public class AppUserDetailsService implements UserDetailsService{
	private static final Logger LOGGER=LoggerFactory.getLogger(AppUserDetailsService.class);
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	User user;
	AppUser appUser;
	public AppUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		LOGGER.debug("AppUserDetailsService parameterized Constructor");
	}
	public AppUserDetailsService() {
		super();
		LOGGER.debug("AppUserDetailsService default Constructor");
	}
	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("LoadUserByUserName Start");
		LOGGER.debug("UserRepository:{}",userRepository);
		user=userRepository.findbyUsername(username);
		LOGGER.debug("User:{}",user);
		if(user==null) {
			throw new UsernameNotFoundException("Username not found");
		}else
			appUser=new AppUser(user);
		LOGGER.info("LoadUserByUserName End");
		return appUser;
	}

	public void signUp(User newUser) throws UserAlreadyExistsException {
		LOGGER.info("SignUp Start");
		User user=new User();
		user=userRepository.findbyUsername(newUser.getUsername());
		if(user==null) {
			Role role=roleRepository.findByRoleId(2);
			String password=newUser.getPassword();
			Set<Role> roleList=new HashSet<Role>();
			roleList.add(role);
			newUser.setRolesList(roleList);
			newUser.setPassword(passwordEncoder().encode(password));
			userRepository.save(newUser);
			
		}else
			throw new UserAlreadyExistsException();
		LOGGER.info("SignUp End");
	}
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Password Encoder");
		return new BCryptPasswordEncoder();
	}
}
