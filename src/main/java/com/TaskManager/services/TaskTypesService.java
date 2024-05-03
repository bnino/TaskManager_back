package com.TaskManager.services;

import java.util.List;

import com.TaskManager.entity.TaskTypes;

public interface TaskTypesService {

    public List<TaskTypes> findAllTaskTypes();

    public TaskTypes saveTask(TaskTypes taskType);

    public TaskTypes updateTaskType(Long id, TaskTypes taskType);

    public void deleteTaskType (Long id);

}
