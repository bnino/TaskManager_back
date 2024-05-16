package com.TaskManager.services;

import com.TaskManager.entity.Enums.TaskStatusList;
import com.TaskManager.entity.TaskStatus;
import com.TaskManager.entity.Tasks;
import com.TaskManager.error.TaskStatusNotFoundException;

import java.util.List;

public interface TaskStatusService {

    public List<TaskStatus> findAllTaskStatus();

    public TaskStatus findTaskStatusById(Long id) throws TaskStatusNotFoundException;

    public TaskStatus save(Tasks idTask, TaskStatusList status);

    public void update(TaskStatus taskStatus);
}
