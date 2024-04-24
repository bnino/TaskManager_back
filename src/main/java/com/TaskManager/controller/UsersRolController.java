package com.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManager.entity.UsersRol;
import com.TaskManager.services.UsersRolService;

@RestController
public class UsersRolController {

    @Autowired
    UsersRolService usersRolService;

    @GetMapping("api/findAllUsersRol")
    public List<UsersRol> findAllusers (){
        return usersRolService.findAllUsers();
    }

    @PostMapping("/api/saveUserRol")
    public UsersRol saveUser(@RequestBody UsersRol user){
        return usersRolService.saveUser(user);
    }

}
