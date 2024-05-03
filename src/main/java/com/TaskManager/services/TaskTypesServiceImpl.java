package com.TaskManager.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.entity.TaskTypes;
import com.TaskManager.repository.TaskTypesRepository;

@Service
public class TaskTypesServiceImpl implements TaskTypesService {

    @Autowired
    TaskTypesRepository taskTypesRepository;

    @Override
    public List<TaskTypes> findAllTaskTypes() {
        
        return taskTypesRepository.findAll();
    }

    @Override
    public TaskTypes saveTask(TaskTypes taskType) {
        return taskTypesRepository.save(taskType);
    }

    @Override
    public TaskTypes updateTaskType(Long id, TaskTypes taskType) {
        TaskTypes taskTypeDb = taskTypesRepository.findById(id).get();

        if (Objects.nonNull(taskType.getDescription()) && !"".equalsIgnoreCase(taskType.getDescription())) {
            taskTypeDb.setDescription(taskType.getDescription());
        }

        return taskTypesRepository.save(taskTypeDb);
    }

    @Override
    public void deleteTaskType(Long id) {
        if( Objects.nonNull(taskTypesRepository.findById(id).get())) taskTypesRepository.deleteById(id);
    }

}
