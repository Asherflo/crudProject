package com.example.crudProject.service;

import com.example.crudProject.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);

    List<User> getAllUser();

    User updateUser( Long id,User user);
}
