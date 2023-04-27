package com.mdbytes.bbc.dao.user;

import com.mdbytes.bbc.dao.DAO;
import com.mdbytes.bbc.entity.User;

public interface UserDAO extends DAO<User> {

    boolean validateUser(String userName, String password);

    void makeUserAdmin(User user);

    
}
