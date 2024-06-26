package com.TaskManager.services;

import java.util.List;
import java.util.Objects;

import com.TaskManager.entity.Enums.UsersRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.entity.Users;
import com.TaskManager.error.UserNotFoundException;
import com.TaskManager.repository.UsersRepository;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> findAllUsers(){
        return usersRepository.findAllUsersByOrderByIdUserASC();
    }

    @Override
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public Users findUserById(Long id) throws UserNotFoundException{
        Optional<Users> user = usersRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User is not found");
        }
        return user.get();
    }

    @Override
    public Users updateUser(Long id, Users user) {
        
        Users userDb = usersRepository.findById(id).get();

        if (Objects.nonNull(user.getDocument()) && !"".equalsIgnoreCase(user.getDocument())) {
        userDb.setDocument(user.getDocument());
        }
        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
            userDb.setEmail(user.getEmail());
        }
        if (Objects.nonNull(user.getFirstname()) && !"".equalsIgnoreCase(user.getFirstname())) {
            userDb.setFirstname(user.getFirstname());
        }
        if (Objects.nonNull(user.getLastname()) && !"".equalsIgnoreCase(user.getLastname())) {
            userDb.setLastname(user.getLastname());
        }
        if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) {
            userDb.setPassword(user.getPassword());
        }
        if (Objects.nonNull(user.getPhone()) && !"".equalsIgnoreCase(user.getPhone())) {
            userDb.setPhone(user.getPhone());
        }
        if (Objects.nonNull(user.getUsername()) && !"".equalsIgnoreCase(user.getUsername())) {
            userDb.setUsername(user.getUsername());
        }
        if (Objects.nonNull(user.getRole()) && user.getRole() != userDb.getRole()) {
            userDb.setRole(user.getRole());
        }

        return usersRepository.save(userDb);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public List<Users> findUsersByUserRole(UsersRole userRole) {
        return usersRepository.findUsersByRoleOrderByFirstnameAsc(userRole);
    }

    @Override
    public List<Users> findSupportUsers() {
        return usersRepository.findUsersByRoleOrderByFirstnameAsc(UsersRole.SUPPORT_USER);
    }
}
