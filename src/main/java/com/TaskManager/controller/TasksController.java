package com.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManager.entity.Tasks;
import com.TaskManager.services.TasksService;

@RestController
public class TasksController {

    @Autowired
    TasksService taskService;

    @GetMapping("/api/findAllTasks")
    public List<Tasks> findAllTasks(){
        return taskService.findAllTasks();
    }

    @PostMapping("/api/saveTask")
    public Tasks saveTask(@RequestBody Tasks task){
        return taskService.saveTask(task);
    }

}
