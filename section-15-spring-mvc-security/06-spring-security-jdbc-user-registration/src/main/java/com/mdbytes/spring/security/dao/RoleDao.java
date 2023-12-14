package com.mdbytes.spring.security.dao;

import com.luv2code.springboot.demosecurity.entity.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);

}
