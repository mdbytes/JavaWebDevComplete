package com.mdbytes.spring.security.dao;


import com.mdbytes.spring.security.model.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}
