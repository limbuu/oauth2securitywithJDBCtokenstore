package com.security.oauth2.repository;


import org.springframework.data.repository.CrudRepository;

import com.security.oauth2.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String username);
}
