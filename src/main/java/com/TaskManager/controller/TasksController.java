package com.TaskManager.controller;

import java.util.List;

import com.TaskManager.controller.models.UpdateTaskStatusRequest;
import com.TaskManager.entity.Enums.TaskStatusList;
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

    @GetMapping("/findByIdTask/{id}")
    public Tasks findByIdTask(@PathVariable Long id){
        return taskService.findTaskById(id);
    }

    @PutMapping("/updateTaskStatus/{id}")
    public Tasks updateTaskStatus(@PathVariable Long id, @RequestBody UpdateTaskStatusRequest status){
        return taskService.updateStatusTask(id, status.getTaskStatus());
    }

    @PostMapping("/saveTask")
    public Tasks saveTask(@RequestBody Tasks task){
        return taskService.saveTask(task);
    }

}
