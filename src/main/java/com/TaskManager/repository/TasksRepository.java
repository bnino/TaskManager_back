package com.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.TaskManager.entity.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long>{

    @Query("SELECT t FROM Tasks t LEFT JOIN FETCH t.statusHistory ts " +
            "WHERE t.idTask = ?1 AND ts.updateDate = " +
            "(SELECT MAX(ts2.updateDate) FROM TaskStatus ts2 WHERE ts2.idTask = t)")
    public Tasks findTaskByIdAndActualStatus(Long id);
}
