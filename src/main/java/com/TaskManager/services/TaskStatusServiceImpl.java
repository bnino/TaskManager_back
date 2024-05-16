package com.TaskManager.services;

import com.TaskManager.entity.Enums.TaskStatusList;
import com.TaskManager.entity.TaskStatus;
import com.TaskManager.entity.Tasks;
import com.TaskManager.error.TaskStatusNotFoundException;
import com.TaskManager.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskStatusServiceImpl implements TaskStatusService{

    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Override
    public List<TaskStatus> findAllTaskStatus() {
        return taskStatusRepository.findAll();
    }

    @Override
    public TaskStatus findTaskStatusById(Long id) throws TaskStatusNotFoundException {
        Optional<TaskStatus> taskStatus = taskStatusRepository.findById(id);
        if (taskStatus.isPresent()) {
            throw new TaskStatusNotFoundException("No results found");
        }
        return taskStatus.get();
    }

    @Override
    public TaskStatus save(Tasks idTask, TaskStatusList status) {
        TaskStatus taskStatus = new TaskStatus();
        taskStatus.setIdTask(idTask);
        taskStatus.setStatus(status);
        return taskStatusRepository.save(taskStatus);

    }

    @Override
    public void update(TaskStatus taskStatus) {

    }
}
