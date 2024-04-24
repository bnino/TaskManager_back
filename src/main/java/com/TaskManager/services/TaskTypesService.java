package com.TaskManager.services;

import java.util.List;

import com.TaskManager.entity.TaskTypes;

public interface TaskTypesService {

    public List<TaskTypes> findAllTaskTypes();

    public TaskTypes saveTask(TaskTypes taskType);

}
