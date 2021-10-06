package com.meFit.meFit.service;

import com.meFit.meFit.models.Role;

//Role service interface
public interface RoleService {

    //Function to create a new role with nested data inside.
    Role createRole(Role role);

    //Function to delete the role with nested data inside.
    void deleteRole(Role role);
}
