package com.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManager.entity.Users;
import com.TaskManager.error.UserNotFoundException;
import com.TaskManager.services.UsersService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;
    
    @GetMapping("/api/findAllUsers")
    public List<Users> findAllusers (){
        return usersService.findAllUsers();
    }

    @GetMapping("/api/findUserById/{id}")
    Users findUserById (@PathVariable Long id) throws UserNotFoundException {
        return usersService.findUserById(id);
    }

    @PostMapping("/api/saveUser")
    public Users saveUser(@Valid @RequestBody Users user){
        return usersService.saveUser(user);
    }
    
    @PutMapping("/api/updateUser/{id}")
    public Users updateUser(@Valid @PathVariable Long id, @RequestBody Users user) {
        return usersService.updateUser(id, user);
    }
    
    @DeleteMapping("/api/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return "User deleted";
    }
    
}
