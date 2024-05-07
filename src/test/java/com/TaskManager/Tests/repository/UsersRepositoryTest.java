package com.TaskManager.Tests.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TaskManager.entity.Users;
import com.TaskManager.repository.UsersRepository;

@SpringBootTest
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @Test
    public void testFindByUsername() {
        Users user = usersRepository.findUserByUsername("bnino").get();
        System.out.println("User: " + user);
    }
}
