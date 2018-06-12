package com.security.oauth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.oauth2.dao.UserDao;
import com.security.oauth2.domain.User;

@RestController
@RequestMapping("/signup")
public class SignupController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping(value="/new")
	public User create(@RequestBody User user) {
		User dbUser = new User();
		dbUser.setUsername(user.getUsername());
		dbUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		dbUser.setAge(user.getAge());
		dbUser.setSalary(user.getSalary());
		
		return this.userDao.save(dbUser);
	}

}
