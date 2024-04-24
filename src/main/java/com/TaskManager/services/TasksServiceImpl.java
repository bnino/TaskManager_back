package com.TaskManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.entity.Tasks;
import com.TaskManager.repository.TasksRepository;

@Service
public class TasksServiceImpl implements TasksService{

    @Autowired
    TasksRepository tasksRepository;

    @Override
    public List<Tasks> findAllTasks() {
        return tasksRepository.findAll();
    }

    @Override
    public Tasks saveTask(Tasks task) {
        return tasksRepository.save(task);
    }

}
