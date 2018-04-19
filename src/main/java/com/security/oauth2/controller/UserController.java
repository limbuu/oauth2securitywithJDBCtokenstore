package com.security.oauth2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.oauth2.api.domain.User;
import com.security.oauth2.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping
	public User addNewUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	@GetMapping
	public User findUser(@RequestParam String username) {
		return this.userRepository.findByUsername(username);
	}
	
}
