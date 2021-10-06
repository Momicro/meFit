package com.meFit.meFit.service;

import com.meFit.meFit.models.User;

//User service interface
public interface UserService {

    //Function to create a new user with nested data inside.
    User createUser(User user);

    //Function to delete the user with nested data inside.
    void deleteUser(User user);
}
