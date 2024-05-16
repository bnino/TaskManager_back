package com.TaskManager.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private TaskStatusRepository taskStatusRepository;

    @Override
    public List<Tasks> findAllTasks() {
        return tasksRepository.findAll();
    }

    @Override
    public Tasks findTaskById(Long idTask) {
        return tasksRepository.findTaskByIdAndActualStatus(idTask);
    }

    @Override
    public Tasks saveTask(Tasks task) {

        var user = usersRepository.findById(task.getIdUser().getId_user()).get();

        var newTask = tasksRepository.save(task);
        newTask.setIdUser(user);

        if (newTask != null){
            TaskStatus status = taskStatusService.save(task, TaskStatusList.RECIBIDO);
            newTask.getStatusHistory().add(status);
        }
        return tasksRepository.save(newTask);
    }

    @Override
    public Tasks updateStatusTask(Long idTask, TaskStatusList status) {
        System.out.println(status);
        Optional<Tasks> findTask = tasksRepository.findById(idTask);

        Tasks newTask = new Tasks();

        if (findTask.isPresent()) {
            Tasks task = findTask.get();

            TaskStatus newStatus = new TaskStatus();

            newStatus.setStatus(status);
            newStatus.setIdTask(task);
            taskStatusRepository.save(newStatus);

            task.getStatusHistory().add(newStatus);
            tasksRepository.save(task);

            return newTask = task;
        }

        return null;
    }

}
