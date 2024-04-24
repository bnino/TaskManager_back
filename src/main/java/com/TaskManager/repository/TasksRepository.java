package com.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManager.entity.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long>{

}
