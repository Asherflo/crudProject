package com.example.crudProject.service;

import com.example.crudProject.model.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
}
