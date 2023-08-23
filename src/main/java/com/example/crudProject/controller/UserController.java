package com.example.crudProject.controller;

import com.example.crudProject.dto.UserDto;
import com.example.crudProject.model.User;
import com.example.crudProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {
    private UserService userService;
@PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto  user){
        UserDto savedUser = userService.createUser(user);
        return new  ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
     UserDto  savedUser =userService.getUserById(id);
     return new ResponseEntity<>(savedUser,HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
    List<UserDto> users = userService.getAllUser();
    return new ResponseEntity<>(users ,HttpStatus.OK);

    }
    @PutMapping("/user/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,
                                           @RequestBody UserDto userDto){
    UserDto updated = userService.updateUser(id,userDto);
    return new ResponseEntity<>(updated,HttpStatus.OK);

    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
    userService.deleteUser(id);
    return  new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
    }
}
