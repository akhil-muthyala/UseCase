package com.assignment.service;
import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assignment.util.Constants;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		if(Constants.ADMIN_USERS.containsKey(username)) {
			return new User(
				username, 
				Constants.ADMIN_USERS.get(username),
				new ArrayList<>()
			);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}