package com.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.TaskManager.entity.TaskTypes;
import com.TaskManager.services.TaskTypesService;

@RestController
public class TaskTypesController {

    @Autowired
    TaskTypesService taskTypesService;

    @GetMapping("/api/findAllTasksTypes")
    public List<TaskTypes> findAllTaskTypes(){
        return taskTypesService.findAllTaskTypes();
    }

    @PostMapping("/api/saveTaskType")
    public TaskTypes saveTaskType(@RequestBody TaskTypes taskType){
        return taskTypesService.saveTask(taskType);
    }

    @PutMapping("/api/updateTaskType")
    public TaskTypes updateTaskType(@PathVariable Long id, @RequestBody TaskTypes taskType){
        return taskTypesService.updateTaskType(id, taskType);
    }

    @DeleteMapping("/api/deleteTaskType")
    public void deleteTaskType(@PathVariable Long id){
        taskTypesService.deleteTaskType(id);
    }

}
