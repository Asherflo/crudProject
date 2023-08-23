package com.example.crudProject.service;

import com.example.crudProject.dto.UserDto;
import com.example.crudProject.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);

    List<UserDto> getAllUser();

    UserDto updateUser( Long id,UserDto userDto);
    void deleteUser(Long id);
}
