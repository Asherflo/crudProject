package com.example.crudProject.controller;

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
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new  ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
     User  savedUser =userService.getUserById(id);
     return new ResponseEntity<>(savedUser,HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
    List<User> users = userService.getAllUser();
    return new ResponseEntity<>(users,HttpStatus.OK);

    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
                                           @RequestBody User user){
    User updated = userService.updateUser(id,user);
    return new ResponseEntity<>(updated,HttpStatus.OK);

    }
}
