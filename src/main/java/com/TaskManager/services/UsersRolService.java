package com.TaskManager.services;

import java.util.List;
import com.TaskManager.entity.UsersRol;

public interface UsersRolService {

    public List<UsersRol> findAllUsers();

    public UsersRol saveUser(UsersRol user);

    public UsersRol findUserById(Long id);

}
