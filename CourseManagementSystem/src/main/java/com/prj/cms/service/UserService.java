package com.prj.cms.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.prj.cms.controller.dto.UserRegistrationDto;
import com.prj.cms.entity.User;

public interface UserService extends UserDetailsService{

	User findByEmail(String email);
	User save(UserRegistrationDto registration);
	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

}
