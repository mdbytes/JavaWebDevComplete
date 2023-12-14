package com.mdbytes.spring.security.service;

import com.mdbytes.spring.security.model.User;
import com.mdbytes.spring.security.model.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

    void save(WebUser webUser);

}
