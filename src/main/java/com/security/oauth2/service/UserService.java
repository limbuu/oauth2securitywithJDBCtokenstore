package com.security.oauth2.service;

import java.util.List;

import com.security.oauth2.domain.User;

public interface UserService{
    User save(User user);
    List<User> findAll();
    void delete(long id);

}
