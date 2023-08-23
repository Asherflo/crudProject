package com.example.crudProject.service.impl;

import com.example.crudProject.dto.UserDto;
import com.example.crudProject.mapper.UserMapper;
import com.example.crudProject.model.User;
import com.example.crudProject.repository.UserRepository;
import com.example.crudProject.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert userDto into user JPA entity
//        User newUser = UserMapper.mapToUser(userDto);
        User  newUser = modelMapper.map(userDto,User.class);
        User savedUsed=  userRepository.save(newUser);

        // convert user JPA entity to userDto
//        UserDto savedUserDto = UserMapper.mapToUserDto(savedUsed);

        UserDto savedUserDto = modelMapper.map(savedUsed,UserDto.class);

        return savedUserDto;


    }

    @Override
    public UserDto getUserById(Long id) {
       Optional<User> user= userRepository.findById(id);
        User anyUser= user.get();
//        return UserMapper.mapToUserDto(anyUser);
        return modelMapper.map(anyUser,UserDto.class);

    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users =userRepository.findAll();

//        return users.stream().map(UserMapper::mapToUserDto)
//                .collect(Collectors.toList());

        return users.stream().map((user)->modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id,UserDto user) {
        User  existingUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User id not found"));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser,UserDto.class) ;

//        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
