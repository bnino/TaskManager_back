package com.TaskManager.repository;

import com.TaskManager.entity.TaskStatus;
import com.TaskManager.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {


    Optional<TaskStatus> findTopByIdTask(Tasks idTask);
}
