package com.TaskManager.services;

import java.util.List;
import java.util.Objects;

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
    public UsersRol updateUserRol(Long id, UsersRol userRol) {
        UsersRol usersRolDb = usersRolRepository.findById(id).get();

        if (Objects.nonNull(userRol.getDescription()) && !"".equalsIgnoreCase(userRol.getDescription())) {
            usersRolDb.setDescription(userRol.getDescription());
        }

        return usersRolRepository.save(usersRolDb);
    }

    @Override
    public void deleteUserRol(Long id) {
        if (Objects.nonNull(usersRolRepository.findById(id).get())) usersRolRepository.deleteById(id);
    }


}
