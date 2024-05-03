package com.TaskManager.services;

import java.util.List;

import com.TaskManager.entity.UsersTasks;

public interface UsersTasksService {

    public List<UsersTasks> findAllUsersTasks();

    public UsersTasks[] saveUsersTasks(UsersTasks[] usersTasks);

    

}
