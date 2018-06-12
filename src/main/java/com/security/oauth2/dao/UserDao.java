package com.security.oauth2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.security.oauth2.domain.User;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
