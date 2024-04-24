package com.TaskManager.services;

import java.util.List;

import com.TaskManager.entity.Users;
import com.TaskManager.error.UserNotFoundException;

public interface UsersService {

    public List<Users> findAllUsers();

    public Users saveUser(Users user);

    public Users findUserById(Long id) throws UserNotFoundException;
    
    public Users updateUser(Long id, Users user);
    
    public void deleteUser(Long id);
    
}
