package com.security.oauth2.oauth2security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.oauth2.repository.UserRepository;

@Service
public class UserDetailServiceManagerImpl implements UserDetailsService{

	@Autowired
	 UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.security.oauth2.api.domain.User user = this.userRepository.findByUsername(username);
		if(user!=null) {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("Cannot find the user with given username :"+username);
		}
	}

}
