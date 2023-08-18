package com.example.crudProject.service.impl;

import com.example.crudProject.model.User;
import com.example.crudProject.repository.UserRepository;
import com.example.crudProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
       Optional<User> user= userRepository.findById(id);
        return user.get();
    }
}
