package com.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.TaskManager.entity.Tasks;
import com.TaskManager.services.TasksService;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

    @Autowired
    private TasksService taskService;

    @GetMapping("/findAll")
    public List<Tasks> findAllTasks(){
        return taskService.findAllTasks();
    }

    @PostMapping("/saveTask")
    public Tasks saveTask(@RequestBody Tasks task){
        return taskService.saveTask(task);
    }

}
