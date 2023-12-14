package com.mdbytes.spring.security.dao;

import com.mdbytes.spring.security.model.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);

}
