package com.security.oauth2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.security.oauth2.api.domain.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	User findByUsername(String username);
}
