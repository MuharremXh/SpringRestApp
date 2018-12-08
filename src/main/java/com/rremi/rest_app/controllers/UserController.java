package com.rremi.rest_app.controllers;

import com.rremi.rest_app.errorHandling.Error;
import com.rremi.rest_app.errorHandling.UserNotFoundException;
import com.rremi.rest_app.entities.User;
import com.rremi.rest_app.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class UserController {
    private com.rremi.rest_app.repositories.userRepository userRepository;

    @Autowired
    public void setUserRepository(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    //show all users
    @GetMapping()
    public  List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    //show only the specified user
    @GetMapping("users/{id}")
    public User user(@PathVariable(name = "id")Long id)
    {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    //add a new user
    @PostMapping("users/addUser")
    public User addUser(@RequestBody User user){
        userRepository.save(user);
        return userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException(user.getId()));
    }

    //handle userNotFoundExceptions
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error userNotfound(UserNotFoundException e){
        long userId = e.getUserId();
        return new Error(404,"User with id: "+userId+" not found");

    }
}
