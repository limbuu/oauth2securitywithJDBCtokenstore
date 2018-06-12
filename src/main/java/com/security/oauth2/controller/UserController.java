package com.security.oauth2.controller;


import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.oauth2.domain.User;
import com.security.oauth2.repository.UserRepository;
import com.security.oauth2.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	    @Autowired
	    private UserService userService;

	    @RequestMapping(value="/user", method = RequestMethod.GET)
	    public List listUser(){
	        return userService.findAll();
	    }

	    @RequestMapping(value = "/user", method = RequestMethod.POST)
	    public User create(@RequestBody User user){
	        return userService.save(user);
	    }

	    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public String delete(@PathVariable(value = "id") Long id){
	        userService.delete(id);
	        return "success";
	    }
	
}
