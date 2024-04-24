package com.TaskManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.entity.UsersTasks;
import com.TaskManager.repository.UsersTasksRepository;

@Service
public class UsersTasksServiceImpl implements UsersTasksService{

    @Autowired
    UsersTasksRepository usersTasksRepository;

    @Override
    public List<UsersTasks> findAllUsersTasks() {
        return usersTasksRepository.findAll();
    }

    @Override
    public UsersTasks[] saveUsersTasks(UsersTasks[] usersTasks) {
        for (UsersTasks userTask : usersTasks) {
            usersTasksRepository.save(userTask);
        }

        return usersTasks;

    }

}
