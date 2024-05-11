package com.TaskManager.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.TaskManager.entity.Users;
import com.TaskManager.error.UserNotFoundException;
import com.TaskManager.services.UsersService;

import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;
    
    @GetMapping("/findAllUsers")
    public List<Users> findAllusers (){
        return usersService.findAllUsers();
    }

    @GetMapping("/findUserById/{id}")
    Users findUserById (@PathVariable Long id) throws UserNotFoundException {
        return usersService.findUserById(id);
    }

    @PostMapping("/saveUser")
    public Users saveUser(@Valid @RequestBody Users user){
        return usersService.saveUser(user);
    }
    
    @PutMapping("/updateUser/{id}")
    public Users updateUser(@Valid @PathVariable Long id, @RequestBody Users user) {
        return usersService.updateUser(id, user);
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return "User deleted";
    }

    @GetMapping("/findSupportUsers")
    public List<Users> findSupportUsers() {
        return usersService.findSupportUsers();
    }
    
}
