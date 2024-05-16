package com.TaskManager.services;

import java.util.List;

import com.TaskManager.entity.Enums.TaskStatusList;
import com.TaskManager.entity.Tasks;

public interface TasksService {

    public List<Tasks> findAllTasks();

    Tasks findTaskById(Long idTask);

    public Tasks saveTask(Tasks task);

    public Tasks updateStatusTask(Long idTask, TaskStatusList status);

}
