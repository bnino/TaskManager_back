package com.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManager.entity.UsersTasks;

@Repository
public interface UsersTasksRepository extends JpaRepository<UsersTasks, Long>{


}
