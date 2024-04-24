package com.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManager.entity.TaskTypes;

@Repository
public interface TaskTypesRepository extends JpaRepository<TaskTypes, Long>{

}
