package com.TaskManager.services;

import java.util.List;

import com.TaskManager.entity.Enums.TaskStatusList;
import com.TaskManager.entity.TaskStatus;
import com.TaskManager.repository.TaskStatusRepository;
import com.TaskManager.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.entity.Tasks;
import com.TaskManager.repository.TasksRepository;

@Service
public class TasksServiceImpl implements TasksService{

    @Autowired
    TasksRepository tasksRepository;

    @Autowired
    TaskStatusService taskStatusService;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Tasks> findAllTasks() {
        return tasksRepository.findAll();
    }

    @Override
    public Tasks saveTask(Tasks task) {

        var user = usersRepository.findById(task.getIdUser().getId_user()).get();

        var newTask = tasksRepository.save(task);
        newTask.setIdUser(user);

        if (newTask != null){
            var taskStatus = TaskStatus.builder()
                    .idTask(newTask)
                    .build();
            taskStatusService.save(taskStatus);
        }
        return tasksRepository.save(newTask);
    }

}
