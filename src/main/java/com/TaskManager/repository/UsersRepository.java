package com.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManager.entity.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository <Users, Long> {
    
    @Query("SELECT u FROM Users u ORDER BY u.id_user ASC")
    List<Users> findAllUsersByOrderByIdUserASC();

    Optional<Users> findByUsername(String name);
}
