package com.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManager.entity.UsersTasks;
import com.TaskManager.services.UsersTasksService;

@RestController
public class UsersTasksController {

    @Autowired
    UsersTasksService usersTasksService;

    @GetMapping("/api/findAllUsersTasks")
    public List<UsersTasks> findAllUsersTasks(){
        return usersTasksService.findAllUsersTasks();
    }

    @PostMapping("/api/saveUsersTasks")
    public UsersTasks[] saveUsersTasks(@RequestBody UsersTasks[] usersTasks){
        return usersTasksService.saveUsersTasks(usersTasks);
    }

}
