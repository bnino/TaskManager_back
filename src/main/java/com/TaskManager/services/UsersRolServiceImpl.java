package com.TaskManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.entity.UsersRol;
import com.TaskManager.repository.UsersRolRepository;

@Service
public class UsersRolServiceImpl implements UsersRolService {

    @Autowired
    UsersRolRepository usersRolRepository;

    @Override
    public List<UsersRol> findAllUsers() {
        return usersRolRepository.findAll();
    }

    @Override
    public UsersRol saveUser(UsersRol user) {
        return usersRolRepository.save(user);
    }

    @Override
    public UsersRol findUserById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserById'");
    }

}
