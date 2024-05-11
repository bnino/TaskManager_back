package com.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.TaskManager.entity.UsersTasks;
import com.TaskManager.services.UsersTasksService;

@RestController
@RequestMapping("/api/usersTasks")
public class UsersTasksController {

    @Autowired
    UsersTasksService usersTasksService;

    @GetMapping("/findAllUsersTasks")
    public List<UsersTasks> findAllUsersTasks(){
        return usersTasksService.findAllUsersTasks();
    }

    @PostMapping("/saveUsersTasks")
    public UsersTasks[] saveUsersTasks(@RequestBody UsersTasks[] usersTasks){
        return usersTasksService.saveUsersTasks(usersTasks);
    }

}
