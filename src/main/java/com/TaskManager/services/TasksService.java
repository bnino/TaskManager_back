package com.TaskManager.services;

import java.util.List;

import com.TaskManager.entity.Tasks;

public interface TasksService {

    public List<Tasks> findAllTasks();

    public Tasks saveTask(Tasks task);

}
