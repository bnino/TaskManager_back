package com.TaskManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.entity.TaskTypes;
import com.TaskManager.repository.TaskTypesRepository;

@Service
public class TaskTypesServiceImpl implements TaskTypesService {

    @Autowired
    TaskTypesRepository taskTypes;

    @Override
    public List<TaskTypes> findAllTaskTypes() {
        
        return taskTypes.findAll();
    }

    @Override
    public TaskTypes saveTask(TaskTypes taskType) {
        return taskTypes.save(taskType);
    }

}
