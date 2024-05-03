package com.TaskManager.services;

import java.util.List;
import com.TaskManager.entity.UsersRol;

public interface UsersRolService {

    List<UsersRol> findAllUsers();

    UsersRol saveUser(UsersRol user);

    UsersRol updateUserRol(Long id, UsersRol user);

    void deleteUserRol(Long id);

}
